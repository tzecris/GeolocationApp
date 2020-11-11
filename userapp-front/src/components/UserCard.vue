<template>
  <div class="userCard">
    <b-card-group
      ><b-card
        bg-variant="info"
        text-variant="white"
        header="Personal Info"
        class="text-left"
        ><b-row>
          <b-col md="2">
            <b-avatar variant="info" color="black" size="4rem"></b-avatar>
          </b-col>
          <b-col md="6">
            <b-card-text
              ><strong>Full Name:</strong> {{ user.firstName }}
              {{ user.lastName }} <br /><strong>AFM:</strong> {{ user.afm }}
              <br /><strong>Age:</strong> {{ user.age }}</b-card-text
            >
          </b-col>
        </b-row>
      </b-card>
      <b-card
        bg-variant="info"
        text-variant="white"
        header="Address Info"
        class="text-left"
        ><b-row>
          <b-col md="2">
            <b-card-img
              :src="require('../assets/address-icon-png-5.png')"
              alt="Image"
              class="rounded-0"
            ></b-card-img>
          </b-col>
          <b-col md="6">
            <b-card-text v-if="user.address"
              >{{ user.address.addressLine }} {{ user.address.addressNo
              }}<br />{{ user.address.city }},
              {{ user.address.zipCode }}</b-card-text
            >
          </b-col>
        </b-row>
      </b-card>
    </b-card-group>
  </div>
</template>

<script>
export default {
  name: "UserCard",
  props: {
    user: {
      type: Object,
    },
  },
  data: () => {
    return {
      user: this.props.user,
    };
  },
};
</script>

<style>
.card-header {
  font-size: 20px;
}
</style>