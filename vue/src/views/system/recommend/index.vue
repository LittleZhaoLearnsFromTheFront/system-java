<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
            label-width="110px">
            <el-form-item label="地形类型" prop="terrainType">
                <el-select v-model="queryParams.terrainType" placeholder="请选择地形类型">
                    <el-option label="平原" :value="1"></el-option>
                    <el-option label="丘陵" :value="2"></el-option>
                    <el-option label="山地" :value="3"></el-option>
                    <el-option label="高原" :value="4"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="海拔" prop="altitude">
                <el-input v-model="queryParams.altitude" placeholder="请输入海拔(米)" clearable />
            </el-form-item>
            <el-form-item label="年平均气温(℃)" prop="avgTemp">
                <el-input v-model="queryParams.avgTemp" placeholder="请输入年平均气温(℃)" clearable />
            </el-form-item>
            <el-form-item label="年降水量(mm)" prop="rainfall">
                <el-input v-model="queryParams.rainfall" placeholder="请输入年降水量(mm)" clearable />
            </el-form-item>
            <el-form-item label="气候带" prop="climateZone">
                <el-input v-model="queryParams.climateZone" placeholder="请输入气候带" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-table v-loading="loading" :data="recommendList">
            <el-table-column label="品种名称" align="center" prop="varietyName" />
            <el-table-column label="推荐产地" align="center" prop="name" />
            <el-table-column label="推荐得分" align="center" prop="score" />
            <el-table-column label="推荐理由" align="center" prop="reason" />
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
            <el-table-column label="备注" align="center" prop="remark" />
        </el-table>
    </div>
</template>

<script>
import { getRecommendList } from "@/api/system/recommend"
export default {
    name: "Recommend",
    data() {
        return {
            // 遮罩层
            loading: false,
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
            recommendList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {}
        }
    },
    methods: {
        /** 查询猕猴桃种类信息列表 */
        getList() {
            if (!this.queryParams.terrainType || !this.queryParams.altitude || !this.queryParams.avgTemp || !this.queryParams.rainfall || !this.queryParams.climateZone) {
                this.$message.error("请输入完整信息")
                return
            }
            this.loading = true
            getRecommendList(this.queryParams).then(response => {
                this.recommendList = response
                this.total = response.length
                this.loading = false
            })
        },
        /** 搜索按钮操作 */
        handleQuery() {
            this.getList()
        },
        /** 重置按钮操作 */
        resetQuery() {
            this.resetForm("queryForm")
            this.recommendList = []
            this.total = 0
        },
        // 多选框选中数据

    }
}
</script>