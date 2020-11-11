<template>
  <div>
    <b-alert variant="variant" show dismissible>{{msg}}</b-alert>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        variant:this.props.variant,
        msg:this.props.msg,
        showDismissibleAlert: false
      }
    },
    methods: {
      showAlert() {
        this.dismissCountDown = this.dismissSecs
      }
    }
  }
</script>