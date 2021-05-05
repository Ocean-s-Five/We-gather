window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 100 || document.documentElement.scrollTop >100) {
       document.getElementById("fixed-nav").style.backgroundColor = "#28a745";
     //  document.getElementById("navbarCollapse > a").style.color = "#000000";
  } else {
       document.getElementById("fixed-nav").style.backgroundColor = "transparent";
     //  document.getElementById("navbarCollapse > a").style.color = "#fff";
  }
}

