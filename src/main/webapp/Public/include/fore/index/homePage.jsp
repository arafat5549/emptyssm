<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 头部导航-开始 -->
	<div id="page-wrapper" style="margin-top:40px;">
	<div class="wrapper wrapper-content animated fadeInRight">
		 <!-- 主题部分-->
		<div class="row">
		
			<div class="col-sm-12">
			    <div class="ibox float-e-margins">
			        <div class="ibox-title">
			            <h5 class="label label-success">新闻中心</h5>
			        </div>
			       
			        <div class="ibox-content">
			           <div class="contact-box">
	                    <div class="col-sm-4">
	                        <div class="text-center">
	                            <img alt="image" class="m-t-xs img-responsive" src="${contextStatic }/img/picture_newsNotice.gif">
	                        </div>
	                    </div>
	                    <div class="col-sm-8">
	                        <c:forEach items="${newsList }" var="item">
	                        	<h3><strong><a href="">${item.title }</a></strong></h3>
	                        </c:forEach>
	                    </div>
	                    <div class="clearfix"></div>
	     				</div>
			        </div>
			    </div>
			</div>
		</div>
		
		<!--  -->
		<div class="row">
				
				<c:forEach items="${xunqinList }" var="item">
				   <div class="col-md-3">
				     <div class="ibox">
                        <div class="ibox-content product-box">
                        	<div class="product-imitation">
                                <img width="128px" height="128px" src="${context }/${item.avatarurl}" alt="${context }/Public/img/a1.jpg" onerror='javascript:this.src="${context }/Public/img/a1.jpg"'>
                            </div> 
                            <c:if test="${item.status == 1 }">
                               <span class="label label-warning">${item.statusName }</span>
                            </c:if>
                            
                            <c:if test="${item.status == 2 }">
                               <span class="label label-success">${item.statusName }</span>
                            </c:if>
                            
                            <div class="product-desc">
                            	<span class="product-price">
                                    ${item.losttypeName } - ${item.logtypeName }
                                </span>
                              
                                <small class="text-muted">联系人:${item.contact }</small>
                                <small class="text-muted pull-right">联系电话 :${item.mobile }</small>
                                <a href="#" class="product-name"> ${item.logname }[${item.birthplace }]</a>
                            
                            	<div class="small m-t-xs">
                                    ${item.note }
                                </div>
                                <div class="m-t text-righ">
                                    <a href="#" class="btn btn-xs btn-outline btn-primary">查看 <i class="fa fa-long-arrow-right"></i> </a>
                                </div>
                            </div>
                        </div>
                     </div>
                   </div>
   				 </c:forEach>
				<!--  
				<div class="col-md-3">
                    <div class="ibox">
                        <div class="ibox-content product-box">

                            <div class="product-imitation">
                                [ INFO ]
                            </div>
                            <div class="product-desc">
                                <span class="product-price">
                                    $10
                                </span>
                                <small class="text-muted">Category</small>
                                <a href="#" class="product-name"> Product</a>



                                <div class="small m-t-xs">
                                    Many desktop publishing packages and web page editors now.
                                </div>
                                <div class="m-t text-righ">

                                    <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i class="fa fa-long-arrow-right"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				-->

            </div>	
			
			
			
</div>
</div>
 