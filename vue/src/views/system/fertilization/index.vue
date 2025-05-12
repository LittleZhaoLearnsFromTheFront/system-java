<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="土地id" prop="landId">
        <LandSelect v-model="queryParams.landId" />
      </el-form-item>
      <el-form-item label="施肥人" prop="owner">
        <el-input v-model="queryParams.owner" placeholder="请输入施肥人" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="施肥时间" prop="time">
        <el-input v-model="queryParams.time" placeholder="请输入施肥时间" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="用量" prop="dosage">
        <el-input v-model="queryParams.dosage" placeholder="请输入用量" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['system:fertilization:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['system:fertilization:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['system:fertilization:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['system:fertilization:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="fertilizationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="土地" align="center" prop="landName" />
      <el-table-column label="施肥人" align="center" prop="owner" />
      <el-table-column label="施肥时间" align="center" prop="time" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用量" align="center" prop="dosage" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:fertilization:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['system:fertilization:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改施肥对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="土地" prop="landId">
          <LandSelect v-model="form.landId" />
        </el-form-item>
        <el-form-item label="施肥人" prop="owner">
          <el-input v-model="form.owner" placeholder="请输入施肥人" />
        </el-form-item>
        <el-form-item label="施肥时间" prop="time">
          <el-date-picker v-model="form.time" type="datetime" placeholder="请选择施肥时间"
            value-format="yyyy-MM-dd HH:mm:ss" />
        </el-form-item>
        <el-form-item label="用量" prop="dosage">
          <el-input v-model="form.dosage" placeholder="请输入用量" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFertilization, getFertilization, delFertilization, addFertilization, updateFertilization } from "@/api/system/fertilization"
import LandSelect from "@/components/Land/index.vue"
export default {
  name: "Fertilization",
  components: {
    LandSelect
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 施肥表格数据
      fertilizationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        landId: null,
        owner: null,
        time: null,
        dosage: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        landId: [
          { required: true, message: "土地id不能为空", trigger: "blur" }
        ],
        owner: [
          { required: true, message: "施肥人不能为空", trigger: "blur" }
        ],
        time: [
          { required: true, message: "施肥时间不能为空", trigger: "blur" }
        ],
        dosage: [
          { required: true, message: "用量不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询施肥列表 */
    getList() {
      this.loading = true
      listFertilization(this.queryParams).then(response => {
        this.fertilizationList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        landId: null,
        owner: null,
        time: null,
        createTime: null,
        updateTime: null,
        createBy: null,
        dosage: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加施肥"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getFertilization(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改施肥"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFertilization(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addFertilization(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除施肥编号为"' + ids + '"的数据项？').then(function () {
        return delFertilization(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => { })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/fertilization/export', {
        ...this.queryParams
      }, `fertilization_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
