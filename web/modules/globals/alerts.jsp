<%-- 
    Document   : alerts.jsp
    Created on : 19-05-2019, 17:25:47
    Author     : willywes
--%>

<div class="col-md-12">
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-check"></i> Éxito!</h4>
            ${success}
        </div>
    </c:if>

    <!--<c:if test="${not empty sucessSession}">
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-check"></i> Éxito!</h4>
            ${sucessSession}
        </div> 
    </c:if>-->

    <c:if test="${not empty warning}">
        <div class="alert alert-warning alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-warning"></i> Advertencia!</h4>
            ${warning}
        </div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-ban"></i> Error!</h4>
            ${error}

            <c:if test="${not empty errors}">
                <ul>
                    <c:forEach var="err" items="${errors}">
                        <li>${err.value}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </c:if>
</div>
