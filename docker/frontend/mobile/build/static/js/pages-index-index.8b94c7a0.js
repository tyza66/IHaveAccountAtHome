(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-index-index"],{"0c28":function(t,e,n){"use strict";n.r(e);var i=n("ab6a"),a=n("2f96");for(var o in a)["default"].indexOf(o)<0&&function(t){n.d(e,t,(function(){return a[t]}))}(o);n("77ac");var s=n("f0c5"),u=Object(s["a"])(a["default"],i["b"],i["c"],!1,null,"3f360835",null,!1,i["a"],void 0);e["default"]=u.exports},"126e":function(t,e,n){var i=n("efbe");i.__esModule&&(i=i.default),"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var a=n("4f06").default;a("09c0c75e",i,!0,{sourceMap:!1,shadowMode:!1})},"2f96":function(t,e,n){"use strict";n.r(e);var i=n("3727"),a=n.n(i);for(var o in i)["default"].indexOf(o)<0&&function(t){n.d(e,t,(function(){return i[t]}))}(o);e["default"]=a.a},3727:function(t,e,n){"use strict";(function(t){n("7a82"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i={data:function(){return{address:"192.168.196.41:8888",outin:0,count:0,usefor:"",other:"",status1:"未验证",status2:"待提交"}},onLoad:function(){},methods:{radioChange:function(e){"支出"===e.detail.value&&(this.outin=0,t("log",this.outin," at pages/index/index.vue:69")),"收入"===e.detail.value&&(this.outin=1,t("log",this.outin," at pages/index/index.vue:73"))},check:function(){var e=this;return uni.showLoading({title:"正在核验输入内容和服务器状态"}),""==this.count||0==this.count?(uni.hideLoading(),void uni.showToast({title:"请输入金额",duration:1e3,icon:"error"})):void 0!=this.count.split(".")[1]&&this.count.split(".")[1].length>2?(uni.hideLoading(),void uni.showToast({title:"金额不能超过两位小数",duration:1e3,icon:"error"})):""==this.usefor?(uni.hideLoading(),void uni.showToast({title:"请输入用途",duration:1e3,icon:"error"})):void uni.request({url:"http://"+this.address+"/check",data:{text:"uni.request"},success:function(n){uni.hideLoading(),t("log",n.data," at pages/index/index.vue:114"),200==n.data.code?(e.status1="已核验",uni.showToast({title:"核验成功",duration:2e3,icon:"success"})):uni.showToast({title:"核验失败",duration:2e3,icon:"error"})},fail:function(){uni.hideLoading(),uni.showToast({title:"核验失败，请检查登录状态和网络",duration:2e3,icon:"error"})}})},submit:function(){var e=this;if(uni.showLoading({title:"正在提交"}),"已核验"!=this.status1)return uni.hideLoading(),void uni.showToast({title:"请先验证再提交",duration:1e3,icon:"error"});uni.request({url:"http://"+this.address+"/bill/add",method:"POST",data:{revenue:this.count,useTo:this.usefor,notes:this.other},header:{"content-type":"application/json"},success:function(n){t("log",n.data," at pages/index/index.vue:166"),200==n.data.code?(e.status2="提交成功，表单已自动复位",e.status1="上次核验内容已提交",e.outin=0,e.count=0,e.usefor="",e.other="",uni.showToast({title:"提交成功",duration:2e3,icon:"success"})):uni.showToast({title:"提交失败",duration:2e3,icon:"error"})},fail:function(){uni.hideLoading(),uni.showToast({title:"提交失败，请检查登录状态和网络",duration:2e3,icon:"error"})}})}}};e.default=i}).call(this,n("0de9")["log"])},"77ac":function(t,e,n){"use strict";var i=n("126e"),a=n.n(i);a.a},ab6a:function(t,e,n){"use strict";n.d(e,"b",(function(){return i})),n.d(e,"c",(function(){return a})),n.d(e,"a",(function(){}));var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",[n("table",{staticClass:"main",attrs:{border:"1"}},[n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("服务器")]),n("td",[n("v-uni-input",{model:{value:t.address,callback:function(e){t.address=e},expression:"address"}})],1)]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("支出")]),n("td",[n("v-uni-radio-group",{on:{change:function(e){arguments[0]=e=t.$handleEvent(e),t.radioChange.apply(void 0,arguments)}}},[n("v-uni-radio",{attrs:{name:"outin",value:"支出",checked:0===t.outin}},[t._v("支出")]),n("v-uni-radio",{attrs:{name:"outin",value:"收入",checked:1===t.outin}},[t._v("收入")])],1)],1)]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("金额")]),n("td",[n("v-uni-input",{attrs:{type:"number"},model:{value:t.count,callback:function(e){t.count=e},expression:"count"}})],1)]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("用途")]),n("td",[n("v-uni-input",{model:{value:t.usefor,callback:function(e){t.usefor=e},expression:"usefor"}})],1)]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("备注")]),n("td",[n("v-uni-textarea",{model:{value:t.other,callback:function(e){t.other=e},expression:"other"}})],1)]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("验证")]),n("td",{class:"未验证"==t.status1?"red":"green"},[t._v(t._s(t.status1))])]),n("tr",[n("td",{attrs:{width:"30%",align:"center"}},[t._v("状态")]),n("td",{class:"待提交"==t.status2?"red":"green"},[t._v(t._s(t.status2))])]),n("tr",[n("td",{attrs:{colspan:" 2"}},[n("v-uni-view",{staticClass:"subs"},[n("v-uni-button",{staticClass:"sub",attrs:{type:"primary"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.check()}}},[t._v("检验")]),n("v-uni-button",{staticClass:"sub",attrs:{type:"primary"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.submit()}}},[t._v("提交")])],1)],1)])])])},a=[]},efbe:function(t,e,n){var i=n("24fb");e=i(!1),e.push([t.i,".main[data-v-3f360835]{width:100%}.subs[data-v-3f360835]{display:flex;justify-content:space-between;width:100%}.sub[data-v-3f360835]{width:%?350?%}.red[data-v-3f360835]{color:red}.green[data-v-3f360835]{color:green}",""]),t.exports=e}}]);