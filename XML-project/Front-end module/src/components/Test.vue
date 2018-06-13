<template>
    <div class="test">

        <input type="text" v-model="title"> <br/>

        <h1>{{title}}</h1>
        <p> {{user.firstName}} </p>
        <p v-text="user.firstName"> </p>
        <p v-if="showName"> John if </p>
        <p v-else> Nobody </p>

        <ul>
            <li v-for="item in items"> {{item.title}} </li>
        </ul>

        <button v-on:click="greet('Hello world')"> Say Greetings </button> 
        <input type="text" v-on:keyup="pressKey" v-on:keyup.enter="enterHit">

        <hr/>

        <label> First name: </label> <input type="text" v-model="user.firstName">

        <br/>

        <label> Last name: </label> <input type="text" v-model="user.lastName">
        
        <br/>

        <h3>{{fullname}}</h3>
    </div>
    
</template>

<script>
export default {
    name: 'test',
    data() {
        return {
            title: 'Hello world',
            user: {
                firstName : 'John',
                lastName : 'Doe'
            },
            showName : true,
            items: [
                {title: 'Item one'},
                {title: 'Item two'}
            ]
        }
    },
    methods: {
        greet: function(greeting) {
            alert(greeting);
        },
        pressKey: function(e) {
            console.log(e.target.value);
        },
        enterHit: function() {
            console.log('You hit enter!');
        }
    },
    computed: {
        fullname: function() {
            return this.user.firstName + ' ' + this.user.lastName;
        }
    }
}
</script>

<style scoped>

</style>


