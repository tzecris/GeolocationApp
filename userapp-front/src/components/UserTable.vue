<template>
  <div>
    <b-table
      striped
      hover
      :items="items"
      :fields="fields"
      @row-clicked="goToUserCard"
    ></b-table>
  </div>
</template>

<script>
import router from "../router";
export default {
  name: "UserTable",
  props: {
    users: {
      type: Array,
    },
  },
  data() {
    return {
      items: this.users,
      fields: [
        { key: "afm", label: "AFM" },
        { key: "firstName", label: "First Name" },
        { key: "lastName", label: "Last Name" },
        { key: "age", label: "Age" },
        { key: "address.addressLine", label: "Address Line" },
        { key: "address.addressNo", label: "Address No" },
        { key: "address.city", label: "City" },
        { key: "address.zipCode", label: "Zip code" },
      ],
    };
  },
  methods: {
    goToUserCard(row) {
      router.push(`/user/${row.afm}`);
    },
  },
};
</script>