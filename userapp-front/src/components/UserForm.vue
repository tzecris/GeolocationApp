<template>
  <div class="container">
    <div>
      <b-alert v-model="showAlert" :variant="variant" dismissible>{{
        msg
      }}</b-alert>
    </div>
    <b-card bg-variant="light">
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group
          label-cols-lg="3"
          label="Fill your Personal Information"
          label-size="lg"
          label-class="font-weight-bold pt-0"
          class="mb-0"
        >
          <b-form-group
            id="firstName_l"
            label="First Name:"
            label-for="firstName"
            label-cols-lg="3"
          >
            <b-form-input
              id="firstName"
              v-model="form.firstName"
              type="text"
              required
              placeholder="Enter your First Name"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="lastName_l"
            label="Last Name:"
            label-for="lastName"
            label-cols-lg="3"
          >
            <b-form-input
              id="lastName"
              v-model="form.lastName"
              required
              placeholder="Enter your Last Name"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="afm_l"
            label="AFM:"
            label-for="afm"
            label-cols-lg="3"
          >
            <b-form-input
              id="afm"
              v-model="form.afm"
              required
              placeholder="Enter your Tax Number"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="age_l"
            label="Age:"
            label-for="age"
            label-cols-lg="3"
          >
            <b-form-input
              id="age"
              type="number"
              v-model="form.age"
              required
              min="18" max="120"
              placeholder="Enter your Age"
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-group
              id="address_l"
              label="Address:"
              label-for="address"
              label-cols-lg="3"
            >
              <b-input-group>
                <b-form-input
                  id="address"
                  v-model="form.address.addressLine"
                  required
                  placeholder="Enter your Address"
                  style="margin-right: 10px"
                ></b-form-input>

                <b-form-input
                  id="addressNo"
                  type="number"
                  v-model="form.address.addressNo"
                  required
                  placeholder="No."
                ></b-form-input>
              </b-input-group>
            </b-form-group>

            <b-form-group
              id="zipCode_l"
              label="Zip Code:"
              label-for="zipCode"
              label-cols-lg="3"
            >
              <b-form-input
                id="zipCode"
                type="number"
                v-model="form.address.zipCode"
                required
                placeholder="Enter your Zip Code"
              ></b-form-input>
            </b-form-group>

            <b-form-group
              id="city_l"
              label="City:"
              label-for="city"
              label-cols-lg="3"
            >
              <b-form-input
                id="city"
                v-model="form.address.city"
                required
                placeholder="Enter your City"
              ></b-form-input>
            </b-form-group>
          </b-form-group>

          <b-button class="btn submitButton" type="submit">Submit</b-button>
          <b-button class="btn resetButton" type="reset" variant="danger"
            >Reset</b-button
          >
        </b-form-group>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      form: {
        afm: "",
        firstName: "",
        lastName: "",
        age: null,
        address: {
          addressLine: "",
          addressNo: null,
          city: "",
          zipCode: null,
        },
      },
      msg: null,
      show: true,
      showAlert: false,
      variant: "",
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      this.showAlert = false;
      axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";

      axios
        .post("http://localhost:8080/app/user/", this.form, {
          responseType: "json",
        })
        .then((response) => {
          if (response.status === 201) {
            this.variant = "success";
            this.showAlert = true;
            this.msg = "User created successfully";
          }
        })
        .catch((error) => {
          if (error.response.status === 400) {
            this.msg = "";
            let test = error.response.data;
            this.variant = "danger";
            this.showAlert = true;
            for (const [key, value] of Object.entries(test)) {
              key;
              this.msg = this.msg + value + " ";
            }
          }
        });
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.afm = null;
      this.form.firstName = "";
      this.form.lastName = null;
      this.form.age = null;
      this.form.address.addressLine = "";
      this.form.address.addressNo = null;
      this.form.address.city = "";
      this.form.address.zipCode = null;
      this.showAlert = false;
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style>
.submitButton {
  background-color: #17a2b8 !important;
  color: #ffffff !important;
  border-color: #17a2b8ff !important;
  margin-right: 5px;
}
.submitButton:hover {
  background-color: #ffff !important;
  color: #17a2b8ff !important;
  border-color: #17a2b8ff !important;
}

.resetButton:hover {
  background-color: #ffff !important;
  color: #dc3545 !important;
  border-color: #dc3545 !important;
}
</style>