import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView'
import BillView from '../views/BillView'
import EscalationView from '../views/EscalationView'
import StatisticsView from '../views/StatisticsView'
import AboutView from '../views/AboutView'
import SettingView from '../views/SettingView'

const routes = [
    { path: '/', component: HomeView },
    { path: '/bill', component: BillView },
    { path: '/escalation', component: EscalationView },
    { path: '/statistics', component: StatisticsView },
    { path: '/about', component: AboutView },
    { path: '/setting', component: SettingView }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router