<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="产地名称" prop="originName">
        <el-input
          v-model="queryParams.originName"
          placeholder="请输入产地名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行政区划代码" prop="regionCode">
        <el-input
          v-model="queryParams.regionCode"
          placeholder="请输入行政区划代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="气候带" prop="climateZone">
        <el-input
          v-model="queryParams.climateZone"
          placeholder="请输入气候带"
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
          v-hasPermi="['system:origin:add']"
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
          v-hasPermi="['system:origin:edit']"
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
          v-hasPermi="['system:origin:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:origin:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="originList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="originId" />
      <el-table-column label="产地名称" align="center" prop="originName" />
      <el-table-column label="行政区划代码" align="center" prop="regionCode" />
      <el-table-column label="气候带" align="center" prop="climateZone" />
      <el-table-column label="最高海拔" align="center" prop="maxAltitude" />
      <el-table-column label="最低海拔" align="center" prop="minAltitude" />
      <el-table-column label="海拔(米)" align="center" prop="altitude" />
      <el-table-column label="坡度(度)" align="center" prop="slope" />
      <el-table-column label="地形类型" align="center" prop="terrainType">
        <template #default="{ row }">
          {{
            {
              1: '平原',
              2: '丘陵',
              3: '山地',
              4: '高原'
            }[row.terrainType] || '未知'
          }}
        </template>
      </el-table-column>
      <el-table-column label="种植面积(亩)" align="center" prop="acreage" />
      <el-table-column label="主要种植品种" align="center" prop="mainVarieties" />
      <el-table-column label="年最高气温(°C)" align="center" prop="maxTemperature" />
      <el-table-column label="年最低气温(°C)" align="center" prop="minTemperature" />
      <el-table-column label="年平均气温(°C)" align="center" prop="avgTemperature" />
      <el-table-column label="最小降水量" align="center" prop="minPrecipitation" />
      <el-table-column label="最大降水量" align="center" prop="maxPrecipitation" />
      <el-table-column label="年降水量(mm)" align="center" prop="precipitation" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:origin:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:origin:remove']"
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

    <!-- 添加或修改猕猴桃产地信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产地名称" prop="originName">
          <el-input v-model="form.originName" placeholder="请输入产地名称" />
        </el-form-item>
        <el-form-item label="行政区划代码" prop="regionCode">
          <el-input v-model="form.regionCode" placeholder="请输入行政区划代码" />
        </el-form-item>
        <el-form-item label="气候带" prop="climateZone">
          <el-input v-model="form.climateZone" placeholder="请输入气候带" />
        </el-form-item>
        <el-form-item label="最高海拔" prop="maxAltitude">
          <el-input v-model="form.maxAltitude" placeholder="请输入最高海拔" />
        </el-form-item>
        <el-form-item label="最低海拔" prop="minAltitude">
          <el-input v-model="form.minAltitude" placeholder="请输入最低海拔" />
        </el-form-item>
        <el-form-item label="海拔(米)" prop="altitude">
          <el-input v-model="form.altitude" placeholder="请输入海拔(米)" />
        </el-form-item>
        <el-form-item label="坡度(度)" prop="slope">
          <el-input v-model="form.slope" placeholder="请输入坡度(度)" />
        </el-form-item>
        <el-form-item label="地形类型" prop="terrainType">
          <el-select v-model="queryParams.terrainType" placeholder="请选择地形类型">
            <el-option label="平原" value="1"></el-option>
            <el-option label="丘陵" value="2"></el-option>
            <el-option label="山地" value="3"></el-option>
            <el-option label="高原" value="4"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="种植面积(亩)" prop="acreage">
          <el-input v-model="form.acreage" placeholder="请输入种植面积(亩)" />
        </el-form-item>
        <el-form-item label="主要种植品种" prop="mainVarieties">
          <el-input v-model="form.mainVarieties" placeholder="请输入主要种植品种" />
        </el-form-item>
        <el-form-item label="年最高气温(°C)" prop="maxTemperature">
          <el-input v-model="form.maxTemperature" placeholder="请输入年最高气温(°C)" />
        </el-form-item>
        <el-form-item label="年最低气温(°C)" prop="minTemperature">
          <el-input v-model="form.minTemperature" placeholder="请输入年最低气温(°C)" />
        </el-form-item>
        <el-form-item label="年平均气温(°C)" prop="avgTemperature">
          <el-input v-model="form.avgTemperature" placeholder="请输入年平均气温(°C)" />
        </el-form-item>
        <el-form-item label="最小降水量" prop="minPrecipitation">
          <el-input v-model="form.minPrecipitation" placeholder="请输入最小降水量" />
        </el-form-item>
        <el-form-item label="最大降水量" prop="maxPrecipitation">
          <el-input v-model="form.maxPrecipitation" placeholder="请输入最大降水量" />
        </el-form-item>
        <el-form-item label="年降水量(mm)" prop="precipitation">
          <el-input v-model="form.precipitation" placeholder="请输入年降水量(mm)" />
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
import { listOrigin, getOrigin, delOrigin, addOrigin, updateOrigin } from "@/api/system/origin"

export default {
  name: "Origin",
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
      // 猕猴桃产地信息表格数据
      originList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        originName: null,
        regionCode: null,
        climateZone: null,
        maxAltitude: null,
        minAltitude: null,
        altitude: null,
        slope: null,
        terrainType: null,
        acreage: null,
        mainVarieties: null,
        maxTemperature: null,
        minTemperature: null,
        avgTemperature: null,
        minPrecipitation: null,
        maxPrecipitation: null,
        precipitation: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询猕猴桃产地信息列表 */
    getList() {
      this.loading = true
      listOrigin(this.queryParams).then(response => {
        this.originList = response.rows
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
        originId: null,
        originName: null,
        regionCode: null,
        climateZone: null,
        maxAltitude: null,
        minAltitude: null,
        altitude: null,
        slope: null,
        terrainType: null,
        acreage: null,
        mainVarieties: null,
        maxTemperature: null,
        minTemperature: null,
        avgTemperature: null,
        minPrecipitation: null,
        maxPrecipitation: null,
        precipitation: null,
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
      this.ids = selection.map(item => item.originId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加猕猴桃产地信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const originId = row.originId || this.ids
      getOrigin(originId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改猕猴桃产地信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.originId != null) {
            updateOrigin(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addOrigin(this.form).then(response => {
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
      const originIds = row.originId || this.ids
      this.$modal.confirm('是否确认删除猕猴桃产地信息编号为"' + originIds + '"的数据项？').then(function() {
        return delOrigin(originIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/origin/export', {
        ...this.queryParams
      }, `origin_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
