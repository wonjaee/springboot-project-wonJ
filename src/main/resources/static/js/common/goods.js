/**
 * 
 */
$(function(){
	goodsListAll();
});
 function goodsDetail(goodsNo){
	 $.ajax({
		 url:`goods/${goodsNo}`,
		 success:function(result){
			 $("main>.wrap").html(result);
		 }
	 })
 }

function goodsListAll(){
	 $.ajax({
		 url:"/man2",
		 success: function(result){
			 $("#goods>.wrap").html(result);
		 }
	 });
 }