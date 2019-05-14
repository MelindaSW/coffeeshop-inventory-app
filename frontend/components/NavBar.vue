<template>
<div class="">
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <img src="../media/coffee-icon.png" width="60" height="60">
      <a class="navbar-item" id="brand-header">
        Coffee Bean Therapy
      </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-start">

        <a class="navbar-item">
          <router-link to="/">Home</router-link>
          </li>
        </a>

        <a class="navbar-item">
          <router-link to="/add">Add Coffee</router-link>
          </li>
        </a>

        <a class="navbar-item">
          <router-link to="/edit">Edit Coffee</router-link>
          </li>
        </a>


      </div>

      <div class="navbar-end">
      </div>
    </div>
  </nav>
</div>
</template>

<script>
export default {}
</script>

<style lang="css" scoped>
  img {
    margin: 10px;
  }
  router-link {
    color: #f5efeb;
  }
  router-link:visited {
    color: black;
  }
  router-link:active {
    color: black;
  }
  .navbar-item {
    font-size: 1.2rem;
  }
  #brand-header  {
    color: black;
    font-weight: bold;

  }
  #brand-header:hover {
    color: black;
  }

  .navbar {
    background-color: #37586f;
  }
</style>
