<template>
    <el-row>
        <el-col :span="24" class="statistics-bg">
            <el-row style="height: 33vh;">
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
            </el-row>
            <el-row  style="height: 33vh;">
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
            </el-row>
            <el-row  style="height: 33vh;">
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
                <el-col :span="8"></el-col>
            </el-row>
        </el-col>
    </el-row>
</template>

<style>
.statistics-bg{
    height: 100vh;
    background-color: rgb(234, 224, 210);
}
</style>

<script>
//import * as echarts from "echarts";

export default {
    name: 'StatisticsView',
    components: {

    },
    data() {
        return {
        }
    },
    methods: {

    }
}
</script>