(function(b){var c=function(g,i,f){var d=document.createElement("img"),e,h;d.onerror=i;d.onload=function(){if(h&&!(f&&f.noRevoke)){c.revokeObjectURL(h)}if(i){i(c.scale(d,f))}};if(c.isInstanceOf("Blob",g)||c.isInstanceOf("File",g)){e=h=c.createObjectURL(g);d._type=g.type}else{if(typeof g==="string"){e=g;if(f&&f.crossOrigin){d.crossOrigin=f.crossOrigin}}else{return false}}if(e){d.src=e;return d}return c.readFile(g,function(k){var j=k.target;if(j&&j.result){d.src=j.result}else{if(i){i(k)}}})},a=(window.createObjectURL&&window)||(window.URL&&URL.revokeObjectURL&&URL)||(window.webkitURL&&webkitURL);c.isInstanceOf=function(d,e){return Object.prototype.toString.call(e)==="[object "+d+"]"};c.transformCoordinates=function(){return};c.getTransformedOptions=function(e,f){var j=f.aspectRatio,k,g,h,d;if(!j){return f}k={};for(g in f){if(f.hasOwnProperty(g)){k[g]=f[g]}}k.crop=true;h=e.naturalWidth||e.width;d=e.naturalHeight||e.height;if(h/d>j){k.maxWidth=d*j;k.maxHeight=d}else{k.maxWidth=h;k.maxHeight=h/j}return k};c.renderImageToCanvas=function(f,j,h,e,d,i,l,k,m,g){f.getContext("2d").drawImage(j,h,e,d,i,l,k,m,g);return f};c.hasCanvasOption=function(d){return d.canvas||d.crop||d.aspectRatio};c.scale=function(v,f){f=f||{};var e=document.createElement("canvas"),h=v.getContext||(c.hasCanvasOption(f)&&e.getContext),r=v.naturalWidth||v.width,n=v.naturalHeight||v.height,g=r,j=n,t,q,m,i,k,d,p,o,u,l=function(){var w=Math.max((m||g)/g,(i||j)/j);if(w>1){g=g*w;j=j*w}},s=function(){var w=Math.min((t||g)/g,(q||j)/j);if(w<1){g=g*w;j=j*w}};if(h){f=c.getTransformedOptions(v,f);p=f.left||0;o=f.top||0;if(f.sourceWidth){k=f.sourceWidth;if(f.right!==undefined&&f.left===undefined){p=r-k-f.right}}else{k=r-p-(f.right||0)}if(f.sourceHeight){d=f.sourceHeight;if(f.bottom!==undefined&&f.top===undefined){o=n-d-f.bottom}}else{d=n-o-(f.bottom||0)}g=k;j=d}t=f.maxWidth;q=f.maxHeight;m=f.minWidth;i=f.minHeight;if(h&&t&&q&&f.crop){g=t;j=q;u=k/d-t/q;if(u<0){d=q*k/t;if(f.top===undefined&&f.bottom===undefined){o=(n-d)/2}}else{if(u>0){k=t*d/q;if(f.left===undefined&&f.right===undefined){p=(r-k)/2}}}}else{if(f.contain||f.cover){m=t=t||m;i=q=q||i}if(f.cover){s();l()}else{l();s()}}if(h){e.width=g;e.height=j;c.transformCoordinates(e,f);return c.renderImageToCanvas(e,v,p,o,k,d,0,0,g,j)}v.width=g;v.height=j;return v};c.createObjectURL=function(d){return a?a.createObjectURL(d):false};c.revokeObjectURL=function(d){return a?a.revokeObjectURL(d):false};c.readFile=function(e,g,f){if(window.FileReader){var d=new FileReader();d.onload=d.onerror=g;f=f||"readAsDataURL";if(d[f]){d[f](e);return d}}return false};if(typeof define==="function"&&define.amd){define(function(){return c})}else{b.loadImage=c}}(this));