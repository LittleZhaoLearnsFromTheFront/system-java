<template>
  <el-select v-model="selectedValue" :placeholder="placeholder" :disabled="disabled" :class="className" :style="style"
    :clearable="clearable" @change="handleChange">
    <el-option v-for="item in originList" :key="item.originId" :label="item.originName" :value="item.originId">
      {{ item.originName }}
    </el-option>
  </el-select>
</template>
<script>
import { getOriginListAll } from "@/api/system/origin"

export default {
  name: 'getOriginListAll',
  props: {
    value: {
      type: String,
      default: ''
    },
    placeholder: {
      type: String,
      default: '请选择'
    },
    disabled: {
      type: Boolean,
      default: false
    },
    className: {
      type: String,
      default: ''
    },
    style: {
      type: Object,
      default: () => ({})
    },
    clearable: {
      type: Boolean,
      default: true
    }
  },

  data() {
    return {
      originList: [],
      selectedValue: this.value
    }
  },
  watch: {
    value(val) {
      this.selectedValue = val
    }
  },
  mounted() {
    this.getOriginList()
  },
  methods: {
    getOriginList() {
      getOriginListAll().then(res => {
        this.originList = res.data
      })
    },
    handleChange(val) {
      this.$emit('input', val)
      this.$emit('change', val)
    }
  }
}
</script>
