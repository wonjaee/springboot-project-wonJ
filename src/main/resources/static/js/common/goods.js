/**
 * 
 */
 function goodsDetail(goodsNo){
	 $.ajax({
		 url:`goods/${goodsNo}`,
		 success:function(result){
			 $("main>.wrap").html(result);
		 }
	 })
 }