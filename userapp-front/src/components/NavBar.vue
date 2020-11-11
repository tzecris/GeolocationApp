<template>
  <div id="navBar">
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="/">UserApp</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="/"><b-icon-house-door-fill /> Home</b-nav-item>
          <b-nav-item href="/user"
            ><b-icon-person-plus-fill /> Add user</b-nav-item
          >
          <b-nav-item href="/users"
            ><b-icon-search /> Search User</b-nav-item
          >
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
     
          <b-nav-item-dropdown right>
            <template v-slot:button-content>
              <b-icon
                style="margin-top: 2.5px"
                icon="info-square-fill"
                font-scale="1.9"
                aria-hidden="true"
              ></b-icon>
            </template>
            <b-dropdown-item href="/about">About</b-dropdown-item>
            <b-dropdown-item href="/contact">Contact us</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<style>
#navBar{
  padding-bottom: 20px;
}
</style>
