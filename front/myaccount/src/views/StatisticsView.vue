<template>
    <el-row>
        <el-col :span="24" class="statistics-bg">
            <el-row style="height: 33vh;">
                <el-col :span="8" id="chart1"></el-col>
                <el-col :span="8" id="chart2"></el-col>
                <el-col :span="8" id="chart3"></el-col>
            </el-row>
            <el-row style="height: 33vh;">
                <el-col :span="8" id="chart4"></el-col>
                <el-col :span="8" id="chart5"></el-col>
                <el-col :span="8" id="chart6"></el-col>
            </el-row>
            <el-row style="height: 33vh;">
                <el-col :span="8" id="chart7"></el-col>
                <el-col :span="8" id="chart8"></el-col>
                <el-col :span="8" id="chart9"></el-col>
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

export default {
    name: 'StatisticsView',
    components: {

    },
    data() {
        return {

        }
    },
    mounted() {
        setTimeout(() => {
            this.initChar1()
            this.initChar2()
            this.initChar3()
            this.initChar4()
            this.initChar5()
            this.initChar6()
            this.initChar7()
            this.initChar8()
            this.initChar9()
        }, 500);

    },
    methods: {
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
                            { value: 1, name: '衣' },
                            { value: 1, name: '食' },
                            { value: 1, name: '住' },
                            { value: 1, name: '行' },
                            { value: 1, name: '宠物' },
                            { value: 1, name: '其他' }
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
                                value: 0.1
                            }
                        ]
                    }
                ]
            });
        },
        initChar3() {
            var chart3 = echarts.init(document.getElementById('chart3'));
            var option = {
                title: {
                    text: '七日消费折线分布',
                    subtext: '当前数据',
                    left: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: ['6天前', '5天前', '4天前', '3天前', '2天前', '1天前', '今日']
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [0, 0, 0, 0, 0, 0, 0],
                        type: 'line'
                    }
                ]
            };
            option && chart3.setOption(option);
            chart3.setOption({
                series: [
                    {
                        data: [0, 0, 0, 1,0, 0, 0]
                    }
                ]
            });
        },
        initChar4() {
            var chart4 = echarts.init(document.getElementById('chart4'));
            var option = {
                title: {
                    text: '本月消费分布',
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
                        name: '本月消费',
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
            option && chart4.setOption(option);
            chart4.setOption({
                series: [
                    {
                        data: [
                            { value: 1, name: '衣' },
                            { value: 1, name: '食' },
                            { value: 1, name: '住' },
                            { value: 1, name: '行' },
                            { value: 1, name: '宠物' },
                            { value: 1, name: '其他' }
                        ]
                    }
                ]
            });
        },
        initChar5() {
            var chart5 = echarts.init(document.getElementById('chart5'));
            var option = {
                title: {
                    text: '本月消费水平',
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
            option && chart5.setOption(option);
            chart5.setOption({
                series: [
                    {
                        data: [
                            {
                                value: 0.1
                            }
                        ]
                    }
                ]
            });
        },
        initChar6() {
            var chart6 = echarts.init(document.getElementById('chart6'));
            var option = {
                title: {
                    text: '半年消费折线分布',
                    subtext: '当前数据',
                    left: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: ['6月前', '5月前', '4月前', '3月前', '2月前', '1月前', '本月']
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [0, 0, 0, 0, 0, 0, 0],
                        type: 'line'
                    }
                ]
            };
            option && chart6.setOption(option);
            chart6.setOption({
                series: [
                    {
                        data: [0, 0, 0, 1,0, 0, 0]
                    }
                ]
            });
        },
        initChar7() {
            var chart7 = echarts.init(document.getElementById('chart7'));
            var option = {
                title: {
                    text: '今年消费分布',
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
                        name: '今年消费',
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
            option && chart7.setOption(option);
            chart7.setOption({
                series: [
                    {
                        data: [
                            { value: 1, name: '衣' },
                            { value: 1, name: '食' },
                            { value: 1, name: '住' },
                            { value: 1, name: '行' },
                            { value: 1, name: '宠物' },
                            { value: 1, name: '其他' }
                        ]
                    }
                ]
            });
        },
        initChar8() {
            var chart8 = echarts.init(document.getElementById('chart8'));
            var option = {
                title: {
                    text: '今年消费水平',
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
            option && chart8.setOption(option);
            chart8.setOption({
                series: [
                    {
                        data: [
                            {
                                value: 0.1
                            }
                        ]
                    }
                ]
            });
        },
        initChar9() {
            var chart9 = echarts.init(document.getElementById('chart9'));
            var option = {
                title: {
                    text: '今年消费折线分布',
                    subtext: '当前数据',
                    left: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: ['1月', '2月', '3月', '4月', '5月', '6月']
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [0, 0, 0, 0, 0, 0, 0],
                        type: 'line'
                    }
                ]
            };
            option && chart9.setOption(option);
            chart9.setOption({
                series: [
                    {
                        data: [0, 0, 0, 1,0, 0, 0]
                    }
                ]
            });
        }
    }
}
</script>