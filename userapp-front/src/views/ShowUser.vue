<template>
  <div class="showUser container">
    <div v-if="user">
      <UserCard v-bind:user="user" />
      <Googlemap v-bind:coordinates="coordinates" />
    </div>
    <div v-if="!user"><p>User not found!</p></div>
  </div>
</template>

<script>
import UserCard from "@/components/UserCard.vue";
import Googlemap from "@/components/Googlemap.vue";
import axios from "axios";

export default {
  name: "ShowUser",
  components: {
    UserCard,
    Googlemap,
  },
  data: () => {
    return {
      user: null,
      coordinates: { lat: 0, lng: 0 },
    };
  },
  created() {
    console.log(this.$route);
    const id = this.$route.params.id;
    axios
      .get(`http://localhost:8080/app/user/${id}`, {
        responseType: "json",
      })
      .then((result) => {
        this.user = result.data;
        this.coordinates.lat = this.user.address.lat;
        this.coordinates.lng = this.user.address.lng;
        console.log(this.coordinates);
      })
      .catch((error) => {
        this.user = null;
        console.log(error);
      });
  },
};
</script>
<style>
.showUser{
  padding-top: 20px;
}
</style>