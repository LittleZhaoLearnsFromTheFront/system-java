<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="品种名称" prop="varietyName">
        <el-input
          v-model="queryParams.varietyName"
          placeholder="请输入品种名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品种学名" prop="scientificName">
        <el-input
          v-model="queryParams.scientificName"
          placeholder="请输入品种学名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:variety:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:variety:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:variety:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:variety:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="varietyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="varietyId" />
      <el-table-column label="品种名称" align="center" prop="varietyName" />
      <el-table-column label="品种学名" align="center" prop="scientificName" />
      <el-table-column label="品种类型" align="center" prop="varietyType" />
      <el-table-column label="育成年份" align="center" prop="breedingYear" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.breedingYear, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="果实形状" align="center" prop="fruitShape" />
      <el-table-column label="果实大小" align="center" prop="fruitSize" />
      <el-table-column label="平均单果重" align="center" prop="averageWeight" />
      <el-table-column label="果面色泽" align="center" prop="skinColor" />
      <el-table-column label="抗病性" align="center" prop="diseaseResistance" />
      <el-table-column label="抗虫性" align="center" prop="insectResistance" />
      <el-table-column label="生长势" align="center" prop="growthVigor" />
      <el-table-column label="病虫害防治措施" align="center" prop="pestControlMeasures" />
      <el-table-column label="适宜产地" align="center" prop="originName" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:variety:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:variety:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改猕猴桃种类信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品种名称" prop="varietyName">
          <el-input v-model="form.varietyName" placeholder="请输入品种名称" />
        </el-form-item>
        <el-form-item label="品种学名" prop="scientificName">
          <el-input v-model="form.scientificName" placeholder="请输入品种学名" />
        </el-form-item>
        <el-form-item label="品种类型" prop="varietyType">
          <el-input v-model="form.varietyType" placeholder="请输入品种类型" />
        </el-form-item>
        <el-form-item label="育成年份" prop="breedingYear">
          <el-date-picker clearable
            v-model="form.breedingYear"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择育成年份">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="果实形状" prop="fruitShape">
          <el-input v-model="form.fruitShape" placeholder="请输入果实形状" />
        </el-form-item>
        <el-form-item label="果实大小" prop="fruitSize">
          <el-input v-model="form.fruitSize" placeholder="请输入果实大小" />
        </el-form-item>
        <el-form-item label="平均单果重" prop="averageWeight">
          <el-input v-model="form.averageWeight" placeholder="请输入平均单果重" />
        </el-form-item>
        <el-form-item label="果面色泽" prop="skinColor">
          <el-input v-model="form.skinColor" placeholder="请输入果面色泽" />
        </el-form-item>
        <el-form-item label="抗病性" prop="diseaseResistance">
          <el-input v-model="form.diseaseResistance" placeholder="请输入抗病性" />
        </el-form-item>
        <el-form-item label="抗虫性" prop="insectResistance">
          <el-input v-model="form.insectResistance" placeholder="请输入抗虫性" />
        </el-form-item>
        <el-form-item label="生长势" prop="growthVigor">
          <el-input v-model="form.growthVigor" placeholder="请输入生长势" />
        </el-form-item>
        <el-form-item label="病虫害防治措施" prop="pestControlMeasures">
          <el-input v-model="form.pestControlMeasures" placeholder="请输入病虫害防治措施" />
        </el-form-item>
        <el-form-item label="适宜产地id" prop="originId">
          <el-input v-model="form.originId" placeholder="请输入适宜产地id" />
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
import { listVariety, getVariety, delVariety, addVariety, updateVariety } from "@/api/system/variety"

export default {
  name: "Variety",
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
      // 猕猴桃种类信息表格数据
      varietyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        varietyName: null,
        scientificName: null,
        varietyType: null,
        breedingYear: null,
        fruitShape: null,
        fruitSize: null,
        averageWeight: null,
        skinColor: null,
        diseaseResistance: null,
        insectResistance: null,
        growthVigor: null,
        pestControlMeasures: null,
        originId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        varietyName: [
          { required: true, message: "品种名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询猕猴桃种类信息列表 */
    getList() {
      this.loading = true
      listVariety(this.queryParams).then(response => {
        this.varietyList = response.rows
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
        varietyId: null,
        varietyName: null,
        scientificName: null,
        varietyType: null,
        breedingYear: null,
        fruitShape: null,
        fruitSize: null,
        averageWeight: null,
        skinColor: null,
        diseaseResistance: null,
        insectResistance: null,
        growthVigor: null,
        pestControlMeasures: null,
        originId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
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
      this.ids = selection.map(item => item.varietyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加猕猴桃种类信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const varietyId = row.varietyId || this.ids
      getVariety(varietyId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改猕猴桃种类信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.varietyId != null) {
            updateVariety(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addVariety(this.form).then(response => {
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
      const varietyIds = row.varietyId || this.ids
      this.$modal.confirm('是否确认删除猕猴桃种类信息编号为"' + varietyIds + '"的数据项？').then(function() {
        return delVariety(varietyIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/variety/export', {
        ...this.queryParams
      }, `variety_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
