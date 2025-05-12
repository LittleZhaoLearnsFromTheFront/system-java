<template>
  <el-select v-model="selectedValue" :placeholder="placeholder" :disabled="disabled" :class="className" :style="style"
    :clearable="clearable" @change="handleChange">
    <el-option v-for="item in landList" :key="item.id" :label="item.name" :value="item.id">
      {{ item.name }}
    </el-option>
  </el-select>
</template>
<script>
import { getLandListAll } from "@/api/system/land"

export default {
  name: 'LandSelect',
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
      landList: [],
      selectedValue: this.value
    }
  },
  watch: {
    value(val) {
      this.selectedValue = val
    }
  },
  mounted() {
    this.getLandList()
  },
  methods: {
    getLandList() {
      getLandListAll().then(res => {
        this.landList = res.data
      })
    },
    handleChange(val) {
      this.$emit('input', val)
      this.$emit('change', val)
    }
  }
}
</script>
