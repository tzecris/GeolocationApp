<template>
  <div class="userresults container">
    <div>
      <b-form>
        <b-input-group size="md" style="padding-bottom: 20px">
          <b-form-input
            placeholder="Enter AFM or Name"
            v-model="inputText"
          ></b-form-input>
          <b-input-group-append>
            <b-button variant="info" type="submit" @click="search"
              >Search</b-button
            >
          </b-input-group-append>
        </b-input-group></b-form
      >
    </div>
    <p >{{ msg }}</p>
    <UserTable v-bind:users="users" :key="childKey" v-if="users.length" />
  </div>
</template>

<script>
import UserTable from "@/components/UserTable.vue";
import axios from "axios";

// let results = [];
export default {
  name: "UserResults",
  data: () => {
    return {
      users: [],
      childKey: 1,
      inputText: "",
      msg: "",
    };
  },
  components: {
    UserTable,
  },
  methods: {
    search(e) {
      e.preventDefault();
      axios
        .get(`http://localhost:8080/app/user/search?text=${this.inputText}`)
        .then((res) => {
          this.users = res.data;
          this.childKey = ++this.childKey;
          if (this.users.length === 0) {
            this.msg = "No results found!";
          } else {
            this.msg = null;
          }
        })
        .catch(() => {
          this.msg = "Something went wrong";
        });
    },
  },
};
</script>
<style>
.userresults {
  padding-top: 20px;
}
</style>