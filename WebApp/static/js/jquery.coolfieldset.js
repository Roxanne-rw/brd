(function(c){function b(e,d){if(d.animation==true){e.find("div").slideUp(d.speed)}else{e.find("div").hide()}e.removeClass("expanded");e.addClass("collapsed")}function a(e,d){if(d.animation==true){e.find("div").slideDown(d.speed)}else{e.find("div").show()}e.removeClass("collapsed");e.addClass("expanded")}c.fn.coolfieldset=function(d){var e={collapsed:false,animation:true,speed:"medium"};c.extend(e,d);this.each(function(){var f=c(this);var g=f.children("legend");if(e.collapsed==true){g.toggle(function(){a(f,e)},function(){b(f,e)});b(f,{animation:false})}else{g.toggle(function(){b(f,e)},function(){a(f,e)})}})}})(jQuery);