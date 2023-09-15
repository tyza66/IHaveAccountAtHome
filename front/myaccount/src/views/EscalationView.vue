<template>
    <el-row>
        <el-col :span="24" class="escalation-bg">
            <el-row>
                <el-col :span="7"></el-col>
                <el-col :span="10">
                    <div>
                        <iframe src="http://192.168.196.41:8889" style="margin-top: 120px;background:white;" height="420px"
                            width="100%"></iframe>
                    </div>
                </el-col>
                <el-col :span="7"></el-col>
            </el-row>
        </el-col>
    </el-row>
</template>

<style>
.escalation-bg {
    height: 100vh;
    background-color: rgb(234, 224, 210);
}
</style>

<script>
export default {
    name: 'EscalationView',
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