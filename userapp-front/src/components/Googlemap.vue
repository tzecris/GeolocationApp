<!-- BaseMap.vue -->
<template>
  <b-card>
    <b-row>
      <b-col mb="8">
        <gmap-map
          :center="center"
          :zoom="15"
          style="width: 500px; height: 300px"
        >
          <gmap-marker
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            :clickable="true"
            :draggable="true"
            @click="center = m.position"
          ></gmap-marker> </gmap-map
      ></b-col>
      <b-col mb="4">
        <b-card-text>
          Push the button to calculate the routed in kilometers from our
          headquarters.
        </b-card-text>
        <b-button @click="calculate" variant="info">Calculate</b-button>
        <b-card-text v-if="calcRoute">
          <br />Your distance in kilometers from our headquarters is: <br />
          {{ calcRoute }} km
        </b-card-text>
        <b-card-text v-if="calcRouteErr" style="color: red">
          <br />{{ calcRouteErr }}
        </b-card-text>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
import axios from "axios";
const premisesCoordinates = "23.735924,37.975290";
export default {
  props: {
    coordinates: {
      type: Object,
    },
  },
  data() {
    return {
      center: this.coordinates,
      markers: [
        {
          position: this.coordinates,
        },
      ],
      calcRoute: null,
      calcRouteErr: null,
      coordinate: this.coordinates,
    };
  },
  methods: {
    calculate() {
      axios
        .get(
          `http://router.project-osrm.org/route/v1/driving/${premisesCoordinates};${this.coordinate.lng},${this.coordinate.lat}?overview=false`
        )
        .then((response) => {
          this.calcRouteErr = null;
          if (response.data.code === "Ok") {
            this.calcRoute = response.data.routes[0].distance / 1000;
          }
        })
        .catch((error) => {
          this.calcRoute = null;
          this.calcRouteErr = "Something went wrong. Try again.";
          console.log(error);
        });
    },
  },
};
</script>