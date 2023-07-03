/**
 * 
 */

 $(function(){
	 $(".menu").click(memuClicked);
 });
 
 function memuClicked(){
	 var check=$(this).hasClass("open");
	 $(".menu").removeClass("open");
	if(!check)$(this).addClass("open");
 }
