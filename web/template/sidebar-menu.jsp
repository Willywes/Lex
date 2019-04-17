<ul class="sidebar-menu" data-widget="tree">
    <li class="header">HEADER</li>
    <!-- Optionally, you can add icons to the links -->
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <li class="active">
        <a href="<c:url value = "modules/usuarios/usuarios.jsp"/>"><i class="fa fa-users"></i><span>Usuarios</span>
        </a>
    </li>
    
    
    <li class="active"><a href="#"><i class="fa fa-link"></i> <span>MEnu 1</span></a></li>
    <li><a href="#"><i class="fa fa-link"></i> <span>MEnu 2</span></a></li>
    <li class="treeview">
        <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
            <li><a href="#">Link in level 2</a></li>
            <li><a href="#">Link in level 2</a></li>
        </ul>
    </li>
</ul>