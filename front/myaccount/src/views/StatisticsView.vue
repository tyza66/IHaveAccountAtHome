<template>
    <el-row>
        <el-col :span="24" class="statistics-bg">
            <el-row style="height:15vh;">
            </el-row>
            <el-row style="height: 33vh;">
                <el-col :span="4"></el-col>
                <el-col :span="8" id="chart1"></el-col>
                <el-col :span="8" id="chart2"></el-col>
            </el-row>
            <el-row style="height: 33vh;">
                <el-col :span="8"></el-col>
                <el-col :span="8" id="chart5"></el-col>
            </el-row>
        </el-col>
    </el-row>
</template>

<style>
.statistics-bg {
    height: 100vh;
    background-color: rgb(234, 224, 210);
}
</style>

<script>
import * as echarts from "echarts";
import request from "../utils/request";

export default {
    name: 'StatisticsView',
    components: {

    },
    data() {
        return {
            allOut: 0,
            out:{
                food: 0,
                clothes: 0,
                live: 0,
                traffic: 0,
                pet: 0,
                other: 0
            },
            allIn: 0,
            in:{
                salary: 0,
                partTime: 0,
                bonus: 0,
                other: 0
            }
        }
    },
    mounted() {
        this.getAllOut();
        this.getEveryIn();
        this.getAllIn();
        setTimeout(() => {
            this.initChar1()
            this.initChar2()
            this.initChar5()
        }, 500);

    },
    methods: {
        getAllOut() {
            request.get('/statistics/allOut',{
                params: {
                    // 时间戳
                    time: new Date().getTime()
                }
            }).then(res => {
                this.allOut = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
        },
        getEveryIn(){
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '衣'
                }
            }).then(res => {
                this.out.clothes = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '食'
                }
            }).then(res => {
                this.out.food = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '住'
                }
            }).then(res => {
                this.out.live = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '行'
                }
            }).then(res => {
                this.out.traffic = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '宠物'
                }
            }).then(res => {
                this.out.pet = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
            request.get('/statistics/oneOut',{
                params: {
                    time: new Date().getTime(),
                    type: '其他'
                }
            }).then(res => {
                this.out.other = res.data?(-res.data):0;
            }).catch(err => {
                console.log(err)
            })
        },
        getAllIn(){
            request.get('/statistics/allIn',{
                params: {
                    // 时间戳
                    time: new Date().getTime()
                }
            }).then(res => {
                this.allIn = res.data?res.data:0;
            }).catch(err => {
                console.log(err)
            })
        },
        initChar1() {
            var chart1 = echarts.init(document.getElementById('chart1'));
            var option = {
                title: {
                    text: '今日消费分布',
                    subtext: '当前数据',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: '今日消费',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            { value: 1, name: '衣' },
                            { value: 1, name: '食' },
                            { value: 1, name: '住' },
                            { value: 1, name: '行' },
                            { value: 1, name: '宠物' },
                            { value: 1, name: '其他' }
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            option && chart1.setOption(option);
            chart1.setOption({
                series: [
                    {
                        data: [
                            { value: this.out.clothes, name: '衣' },
                            { value: this.out.food, name: '食' },
                            { value: this.out.live, name: '住' },
                            { value: this.out.traffic, name: '行' },
                            { value: this.out.pet, name: '宠物' },
                            { value: this.out.other, name: '其他' }
                        ]
                    }
                ]
            });
        },
        initChar2() {
            var chart2 = echarts.init(document.getElementById('chart2'));
            var option = {
                title: {
                    text: '今日消费水平',
                    left: 'center'
                },
                series: [
                    {
                        type: 'gauge',
                        startAngle: 180,
                        endAngle: 0,
                        center: ['50%', '75%'],
                        radius: '90%',
                        min: 0,
                        max: 1,
                        splitNumber: 8,
                        axisLine: {
                            lineStyle: {
                                width: 6,
                                color: [
                                    [0.25, '#7CFFB2'],
                                    [0.5, '#58D9F9'],
                                    [0.75, '#FDDD60'],
                                    [1, '#FF6E76']
                                ]
                            }
                        },
                        pointer: {
                            icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
                            length: '12%',
                            width: 20,
                            offsetCenter: [0, '-60%'],
                            itemStyle: {
                                color: 'auto'
                            }
                        },
                        axisTick: {
                            length: 12,
                            lineStyle: {
                                color: 'auto',
                                width: 2
                            }
                        },
                        splitLine: {
                            length: 20,
                            lineStyle: {
                                color: 'auto',
                                width: 5
                            }
                        },
                        axisLabel: {
                            color: '#464646',
                            fontSize: 20,
                            distance: -60,
                            rotate: 'tangential',
                            formatter: function (value) {
                                if (value === 0.875) {
                                    return '超标消费';
                                } else if (value === 0.625) {
                                    return '普通消费';
                                } else if (value === 0.375) {
                                    return '低消费';
                                } else if (value === 0.125) {
                                    return '超低消费';
                                }
                                return '';
                            }
                        },
                        title: {
                            offsetCenter: [0, '-10%'],
                            fontSize: 20
                        },
                        detail: {
                            fontSize: 30,
                            offsetCenter: [0, '-35%'],
                            valueAnimation: true,
                            formatter: function (value) {
                                return Math.round(value * 100) + '';
                            },
                            color: 'inherit'
                        },
                        data: [
                            {
                                value: 0.0
                            }
                        ]
                    }
                ]
            };
            option && chart2.setOption(option);
            chart2.setOption({
                series: [
                    {
                        data: [
                            {
                                value: this.allOut/200
                            }
                        ]
                    }
                ]
            });
        },
        initChar5() {
            var chart5 = echarts.init(document.getElementById('chart5'));
            var option = {
                title: {
                    text: '今日收入水平',
                    left: 'center'
                },
                series: [
                    {
                        type: 'gauge',
                        startAngle: 180,
                        endAngle: 0,
                        center: ['50%', '75%'],
                        radius: '90%',
                        min: 0,
                        max: 1,
                        splitNumber: 8,
                        axisLine: {
                            lineStyle: {
                                width: 6,
                                color: [
                                    [0.25, '#7CFFB2'],
                                    [0.5, '#58D9F9'],
                                    [0.75, '#FDDD60'],
                                    [1, '#FF6E76']
                                ]
                            }
                        },
                        pointer: {
                            icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
                            length: '12%',
                            width: 20,
                            offsetCenter: [0, '-60%'],
                            itemStyle: {
                                color: 'auto'
                            }
                        },
                        axisTick: {
                            length: 12,
                            lineStyle: {
                                color: 'auto',
                                width: 2
                            }
                        },
                        splitLine: {
                            length: 20,
                            lineStyle: {
                                color: 'auto',
                                width: 5
                            }
                        },
                        axisLabel: {
                            color: '#464646',
                            fontSize: 20,
                            distance: -60,
                            rotate: 'tangential',
                            formatter: function (value) {
                                if (value === 0.875) {
                                    return '几乎没赚';
                                } else if (value === 0.625) {
                                    return '挣点小钱';
                                } else if (value === 0.375) {
                                    return '基本收入';
                                } else if (value === 0.125) {
                                    return '发财了';
                                }
                                return '';
                            }
                        },
                        title: {
                            offsetCenter: [0, '-10%'],
                            fontSize: 20
                        },
                        detail: {
                            fontSize: 30,
                            offsetCenter: [0, '-35%'],
                            valueAnimation: true,
                            formatter: function (value) {
                                return Math.round(value * 100) + '';
                            },
                            color: 'inherit'
                        },
                        data: [
                            {
                                value: 0.0
                            }
                        ]
                    }
                ]
            };
            option && chart5.setOption(option);
            chart5.setOption({
                series: [
                    {
                        data: [
                            {
                                value: this.allIn/200
                            }
                        ]
                    }
                ]
            });
        }
    }
}
</script>