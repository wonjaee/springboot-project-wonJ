/**
 * 
 */

 $(function(){
	 $(".menu").click(memuClicked);
	 $(".menu-wrap a").click(memuItemClicked)
 });
 function memuItemClicked(event){
	 event.preventDefault();
	 
	 $.get(
		 $(this).attr("href"),
		 function(resultMain){
			 $("main>.wrap").html(resultMain);
		 });
 }
 
 
 function memuClicked(){
	 var check=$(this).hasClass("open");
	 $(".menu").removeClass("open");
	if(!check)$(this).addClass("open");
 }
