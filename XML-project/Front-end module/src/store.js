import Vue from 'vue'
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    plugins: [],
    state: {
        ListOfAccommodations : []
    },
    getters: {}, // moze da modifikuje state kad ga vraca primer sa cenom koja je na akciji
    mutations: {}, // f-je kojima kada hocu da promenim tu listu, push itd onda njima radim jer sa njima mogu akcije da radim
    // a to je isto kao i mutacije samo za async
    actions: {} // akcije radim u kombinaciji sa mutacijama za async
    
})