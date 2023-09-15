<template>
	<view>
		<table class="main" border="1">
			<tr>
				<td width="30%" align="center">服务器</td>
				<td><input v-model="address" /></td>
			</tr>
			<tr>
				<td width="30%" align="center">收支</td>
				<td>
					<radio-group @change="radioChange">
						<radio name="outin" value="支出" :checked="outin === 0">支出</radio>
						<radio name="outin" value="收入" :checked="outin === 1">收入</radio>
					</radio-group>
				</td>
			</tr>
			<tr>
				<td width="30%" align="center">金额</td>
				<td><input v-model="count" type="number" /></td>
			</tr>
			<tr>
				<td width="30%" align="center">用途</td>
				<td>
					<picker @change="bindPickerChange" :value="index" :range="array">
						<view class="uni-input">{{array[index]}}</view>
					</picker>
				</td>
			</tr>
			<tr>
				<td width="30%" align="center">备注</td>
				<td><textarea v-model="other" /></td>
			</tr>
			<tr>
				<td width="30%" align="center">验证</td>
				<td :class="(status1=='未验证'?'red':'green')">{{status1}}</td>
			</tr>
			<tr>
				<td width="30%" align="center">状态</td>
				<td :class="(status2=='待提交'?'red':'green')">{{status2}}</td>
			</tr>
			<tr>
				<td colspan=" 2">
					<view class="subs">
						<button type="primary" class="sub" @click="check()">检验</button>
						<button type="primary" class="sub" @click="submit()">提交</button>
					</view>
				</td>
			</tr>
		</table>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				address: "192.168.196.41:8888",
				outin: 0,
				count: 0,
				usefor: "",
				other: "",
				status1: "未验证",
				status2: "待提交",
				array: ["请选择", '衣', '食', '住', '行', '宠物', '其他', '收入'],
				index: 0,
			}
		},
		onLoad() {

		},
		methods: {
			radioChange(evt) {
				if ("支出" === evt.detail.value) {
					this.outin = 0;
					console.log(this.outin)
				}
				if ("收入" === evt.detail.value) {
					this.outin = 1;
					console.log(this.outin)
				}
			},
			check() {
				console.log(this.usefor)
				uni.showLoading({
					title: '正在核验输入内容和服务器状态'
				});
				if (this.count == "" || this.count == 0) {
					uni.hideLoading();
					uni.showToast({
						title: '请输入金额',
						duration: 1000,
						icon: "error"
					});
					return;
				}
				if (this.count.split(".")[1] != undefined && this.count.split(".")[1].length > 2) {
					uni.hideLoading();
					uni.showToast({
						title: '金额不能超过两位小数',
						duration: 1000,
						icon: "error"
					});
					return;
				}
				if (this.usefor == "" || this.usefor == "请选择") {
					uni.hideLoading();
					uni.showToast({
						title: '请选择用途',
						duration: 1000,
						icon: "error"
					});
					return;
				}
				uni.request({
					url: 'http://' + this.address + '/check',
					data: {
						text: 'uni.request'
					},
					success: (res) => {
						uni.hideLoading();
						console.log(res.data);
						if (res.data.code == 200) {
							this.status1 = "已核验"
							uni.showToast({
								title: '核验成功',
								duration: 2000,
								icon: "success"
							});
						} else {
							uni.showToast({
								title: '核验失败',
								duration: 2000,
								icon: "error"
							});
						}

					},
					fail() {
						uni.hideLoading();
						uni.showToast({
							title: '核验失败，请检查登录状态和网络',
							duration: 2000,
							icon: "error"
						});
					}
				});
			},
			submit() {
				uni.showLoading({
					title: '正在提交'
				});
				if (this.status1 != "已核验") {
					uni.hideLoading();
					uni.showToast({
						title: '请先验证再提交',
						duration: 1000,
						icon: "error"
					});
					return;
				}
				uni.request({
					url: 'http://' + this.address + '/bill/add',
					method: 'POST',
					data: {
						revenue: ((this.outin == 0) ? "-" : "") + this.count,
						useTo: this.usefor,
						notes: this.other
					},
					header: {
						'content-type': 'application/json'
					},
					success: (res) => {
						console.log(res.data)
						if (res.data.code == 200) {
							this.status2 = "提交成功，表单已自动复位"
							this.status1 = "上次核验内容已提交"
							this.outin = 0
							this.count = 0
							this.usefor = ""
							this.other = ""
							this.index = 0
							uni.showToast({
								title: '提交成功',
								duration: 2000,
								icon: "success"
							});
						} else {
							uni.showToast({
								title: '提交失败',
								duration: 2000,
								icon: "error"
							});
						}
					},
					fail() {
						uni.hideLoading();
						uni.showToast({
							title: '提交失败，请检查登录状态和网络',
							duration: 2000,
							icon: "error"
						});
					}
				});
			},
			bindPickerChange: function(e) {
				console.log('picker发送选择改变，携带值为', e.detail.value)
				this.index = e.detail.value
				this.usefor = this.array[this.index]
			}
		}
	}
</script>

<style>
	.main {
		width: 100%;
	}

	.subs {
		display: flex;
		justify-content: space-between;
		width: 100%;
	}

	.sub {
		width: 350rpx;
	}

	.red {
		color: red;
	}

	.green {
		color: green;
	}
</style>