<template>
  <el-config-provider :locale="locale">
    <el-row class="main">
      <el-col :span="4">
        <div class="main-left">
          <div class="main-title">
            我家有账
          </div>
          <div class="main-item" @click="routerTo(0)">
            首页
          </div>
          <div class="main-item" @click="routerTo(1)">
            报账
          </div>
          <div class="main-item" @click="routerTo(2)">
            账单
          </div>
          <div class="main-item" @click="routerTo(3)">
            统计
          </div>
          <div class="main-item" @click="routerTo(5)">
            设置
          </div>
          <div class="main-item" @click="routerTo(4)">
            关于
          </div>
        </div>
      </el-col>
      <el-col :span="20">
        <RouterView></RouterView>
      </el-col>
    </el-row>
  </el-config-provider>
</template>

<script>
import { ElConfigProvider } from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

export default {
  name: 'App',
  components: {
    [ElConfigProvider.name]: ElConfigProvider
  },
  data(){
    return{
      locale: zhCn
    }
  },
  methods: {
    routerTo(id) {
      if (id == 0) {
        this.$router.push({ path: '/' })
      } else if (id == 1) {
        this.$router.push({ path: '/escalation' })
      } else if (id == 2) {
        this.$router.push({ path: '/bill' })
      } else if (id == 3) {
        this.$router.push({ path: '/statistics' })
      } else if (id == 4) {
        this.$router.push({ path: '/about' })
      } else if (id == 5) {
        this.$router.push({ path: '/setting' })
      }
    }
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.main {
  height: 100%;
}

.main-left {
  width: 100%;
  height: 100vh;
  background-color: antiquewhite;
  float: left;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.main-title {
  font-size: 30px;
  text-align: center;
  margin-top: 30px;
  font-family: 'Courier New', Courier, monospace;
}

.main-item {
  font-size: 20px;
  text-align: center;
  margin-top: 20px;
  width: 80%;
  height: 40px;
  border: 1px solid #223067;
  border-radius: 5px;
  text-align: center;
  line-height: 40px;
  cursor: pointer;
}

RouterView {
  height: 100vh;
}</style>
