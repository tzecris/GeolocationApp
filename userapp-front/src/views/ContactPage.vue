<template>
  <div class="contact container">
    <b-card class="contactHeader"
      header=" "
      margin="30px"
      tag="article"
    >
      <b-card-text class="text-left">
        <h4>Any questions? Feel free to call us, an expert will answer your
        questions.</h4>
        <br>
        <h6>
          <b-icon-signpost-split-fill></b-icon-signpost-split-fill> Address:
          <span>Papandreou 35, Aigaleo 12243</span>
        </h6><br>
        <h6>
          <b-icon-telephone-fill></b-icon-telephone-fill> Tel:
          <span>2109999999</span>
        </h6><br>
        <h6>
          <b-icon-printer-fill></b-icon-printer-fill> Fax:
          <span>2108888888</span>
        </h6><br>
        <h6>
          <b-icon-envelope-fill></b-icon-envelope-fill> Email:
          <span>info@example.gr</span>
        </h6>
      </b-card-text>
    </b-card>
  </div>
  
</template>

<style>
.card {
  border: none!important;
}
.contact .card-header {
  min-height: 230px;
  margin-bottom: 20px;
  color: #26494e;
  font-weight: 600;
  background-repeat: no-repeat;
    background-size: 100% 120%;
  background-image: url("../assets/contact.png");
}
.card-header:first-child {
  padding-top: 20px;
}

#navBar{
  padding-bottom: 0;
}
</style>