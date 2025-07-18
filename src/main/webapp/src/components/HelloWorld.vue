<template>
  <h1>{{ msg }}</h1>

  <div class="card">
    <button type="button" @click="incrementSimple">simple counter is {{ simpleCounter }}</button>
    <button type="button" @click="logRandom">random {{ randomCounter }}</button>
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
import {CounterService} from "../jcef/CounterService.ts";
import type {CountResponse} from "../io/github/bitfist/jcef/spring/example/CountResponse.ts";

defineProps<{ msg: string }>()

const simpleCounter = ref(0)
const objectCounter = ref(0)
const randomCounter = ref(0)

function incrementSimple() {
  CounterService.simple(simpleCounter.value).then((newCount: number) => {
    simpleCounter.value = newCount
  }).catch(error => {
    console.error('Failed to increment counter:', error)
  })
}
function incrementObject() {
  let counter = objectCounter.value + 1;
  CounterService.count(counter, { count: counter } ).then((newCount: CountResponse) => {
    objectCounter.value = newCount.count
  }).catch(error => {
    console.error('Failed to increment counter:', error)
  })
}

function logRandom() {
  CounterService.random().then((randomNumber: number) => {
    randomCounter.value = randomNumber;
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
