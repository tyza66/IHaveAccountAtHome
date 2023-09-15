<template>
    <el-row>
        <el-col :span="24" class="bill-bg">
            <el-row style="height:10vh;">
                <el-row style="height:5vh;width:100%;">
                    <el-col :span="6" class="bill-search">
                        用途： <el-select size="small" style="display:inline;width:150px;" placeholder="选择通途过滤"
                            v-model="searchtable.usefor">
                            <el-option label="衣" value="衣" />
                            <el-option label="食" value="食" />
                            <el-option label="住" value="住" />
                            <el-option label="行" value="行" />
                            <el-option label="宠物" value="宠物" />
                            <el-option label="其他" value="其他" />
                            <el-option label="收入" value="收入" />
                        </el-select>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        备注：<el-input size="small" style="display:inline;width:150px;" placeholder="根据备注信息查询"
                            v-model="searchtable.notes"></el-input>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        收支：<el-select size="small" style="display:inline;width:150px;" placeholder="收入还是支出"
                            v-model="searchtable.inorout">
                            <el-option label="收入" value="up" />
                            <el-option label="支出" value="down" />
                        </el-select>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        共{{ sum }}条记录，每页{{ searchtable.size }}条，当前第{{ searchtable.page }}页
                    </el-col>
                </el-row>
                <el-row style="height:5vh;width:100%;">
                    <el-col :span="6" class="bill-search">
                        开始： <el-date-picker size="small" style="display:inline;width:150px;" placeholder="选择起始时间"
                            v-model="searchtable.start"></el-date-picker>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        直到：<el-date-picker size="small" style="display:inline;width:150px;" placeholder="选择直到时间"
                            v-model="searchtable.end"></el-date-picker>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        页码：<el-select size="small" style="display:inline;width:150px;" placeholder="收入还是支出"
                            v-model="this.searchtable.page">
                            <el-option v-for="i in pages" :label="i" :value="i" :key="i" />
                        </el-select>
                    </el-col>
                    <el-col :span="6" class="bill-search">
                        <el-button type="primary" size="small" @click="statistics()">统计</el-button>
                        <el-button type="primary" size="small" @click="clear()">清空</el-button>
                        <el-button type="primary" size="small" @click="getTable()">查询</el-button>
                    </el-col>
                </el-row>
            </el-row>
            <el-row style="height:90vh">
                <el-table :data="tableData" height="100%" style="width: 100">
                    <el-table-column prop="timeString" label="上报时间" width="200px" />
                    <el-table-column prop="revenue" label="金额" width="200px" />
                    <el-table-column prop="useTo" label="用途" width="170px" />
                    <el-table-column prop="notes" label="备注" width="400px" />
                    <el-table-column prop="notes" label="操作" width="260px">
                        <template #default="scope">
                            <el-button @click="edit1(scope.row)">编辑</el-button>
                            <el-button @click="delete1(scope.row)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-row>
        </el-col>
    </el-row>
</template>

<style>
.bill-bg {
    height: 100vh;
    background-color: rgb(234, 224, 210);
}

.bill-search {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}
</style>

<script>
import request from "../utils/request";

export default {
    name: 'BillView',
    components: {

    },
    data() {
        return {
            tableData: [],
            sum: 0,
            pages: 1,
            searchtable: {
                usefor: '',
                notes: '',
                inorout: '',
                start: '',
                end: '',
                page: 1,
                size: 12
            }
        }
    },
    mounted() {
        this.getTableInit();
    },
    methods: {
        getTableInit() {
            request.get("/bill/get", {
                params: {
                    size: this.searchtable.size,
                    page: this.searchtable.page - 1
                }
            }).then(res => {
                console.log(res.data)
                this.tableData = res.data
                this.sum = res.size;
                console.log(this.sum)
                if (this.sum % this.searchtable.size == 0) {
                    this.pages = Math.floor(this.sum / this.searchtable.size);
                } else {
                    this.pages = Math.floor(this.sum / this.searchtable.size) + 1;
                }
                if (this.pages == 0) {
                    this.pages = 1;
                }
            })
        },
        getTable() {
            request.get("/bill/get", {
                params: {
                    infoKey: this.searchtable.usefor,
                    noteKey: this.searchtable.notes,
                    upOrDown: this.searchtable.inorout,
                    startTime: this.searchtable.start,
                    endTime: this.searchtable.end,
                    size: this.searchtable.size,
                    page: this.searchtable.page - 1
                }
            }).then(res => {
                this.tableData = res.data
                this.sum = res.size;
                if (this.sum % this.searchtable.size == 0) {
                    this.pages = Math.floor(this.sum / this.searchtable.size);
                } else {
                    this.pages = Math.floor(this.sum / this.searchtable.size) + 1;
                }
                if (this.pages == 0) {
                    this.pages = 1;
                }
                this.searchtable.page = 1
            })
        },
        clear() {
            this.searchtable.usefor = '';
            this.searchtable.notes = '';
            this.searchtable.inorout = '';
            this.searchtable.start = '';
            this.searchtable.end = '';
        },
        statistics() {
            this.$router.push({ path: '/statistics' })
        },
        delete1(row){
            console.log(row)
        },
        edit1(row){
            console.log(row)
        }
    }
}
</script>