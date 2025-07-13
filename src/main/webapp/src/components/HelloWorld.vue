<template>
  <h1>{{ msg }}</h1>

  <div class="card">
    <button type="button" @click="incrementSimple">simple counter is {{ simpleCounter }}</button>
    <button type="button" @click="logRandom">random</button>
    <button type="button" @click="incrementObject">object counter is {{ objectCounter }}</button>
  </div>

  <p>
    Check out
    <a href="https://vuejs.org/guide/quick-start.html#local" target="_blank">
      create-vue
    </a>, the official Vue + Vite starter
  </p>
  <p>
    Learn more about IDE Support for Vue in the
    <a
        href="https://vuejs.org/guide/scaling-up/tooling.html#ide-support"
        target="_blank"
    >Vue Docs Scaling up Guide</a
    >.
  </p>
  <p class="read-the-docs">Click on the Vite and Vue logos to learn more</p>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import {CounterQueryHandler, type CounterResponse} from '../io/github/bitfist/jcef/spring/example/infrastructure/CounterQueryHandler'

defineProps<{ msg: string }>()

const simpleCounter = ref(0)
const objectCounter = ref(0)

function incrementSimple() {
  CounterQueryHandler.simple(simpleCounter.value + 1).then((newCount: number) => {
    simpleCounter.value = newCount
  }).catch(error => {
    console.error('Failed to increment counter:', error)
  })
}
function incrementObject() {
  let counter = objectCounter.value + 1;
  CounterQueryHandler.count(counter, { counter } ).then((newCount: CounterResponse) => {
    objectCounter.value = newCount.counter
  }).catch(error => {
    console.error('Failed to increment counter:', error)
  })
}

function logRandom() {
  CounterQueryHandler.logRandom().then(() => {
    console.log('Random log message sent')
  }).catch(error => {
    console.error('Failed to send random log message:', error)
  })
}
</script>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
