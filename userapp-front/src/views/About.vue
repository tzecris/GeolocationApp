<template>
  <div class="about">
    <!-- <div class="contact container"> -->
    <b-card-group deck>
      <b-card
        margin="30px"
        header="About us"
        align="center"
      >
        <b-card-text style="padding:0 120px 0 120px">
          This is a web application where the user is able to insert his
          personal and address information, using the address the application is
          able to calculate a location using Google Maps. Also the application
          is able to measure the user's address from our
          headquarters.</b-card-text
        >
      </b-card>
    </b-card-group>
    <!-- </div> -->
  </div>
</template>
<style>
.card {
  border: none;
}
.card-header {
  min-height: 350px;
  margin-bottom: 20px;
  color: #26494e;
  font-weight: 600;
  background-repeat: no-repeat;
  background-size: cover;
  background-image: url("../assets/Tech_Explained_Location_Intelligence_Springwise-1024x600.jpg");
}
.card-header:first-child {
  padding-top: 20px;
}
#navBar{
  padding-bottom: 0;
}
</style>