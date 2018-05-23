<div class="header-main">
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#glmt-menu" onclick="toggleMenu()">
                <span class="sr-only">Toggle</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="logo1"></div>
        </div>

        <div class="navbar-collapse collapse" id="glmt-menu">
            <div class="top-right-menu navbar-right hidden-xs">
                <a href="/logout" title="Logout" class="btn">Logout</a>
            </div>

        </div>
    </div>
    <div role="navigation">
        <div class="main-menu hidden-xs">
            <div class="wlcm-cont">
                Welcome  ${user} !
            </div>
            <ul class="menu" id="topbar">
                <c:choose>
                    <c:when test="${empty user}">
                        <a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/welcome">
                            <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                                 xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 35.933 35.933"
                                 style="enable-background:new 0 0 35.933 35.933;" xml:space="preserve"><g>
                                <path d="M29.646,10.461c-3.14-2.693-7.215-4.331-11.682-4.331C8.043,6.13,0,14.173,0,24.099c0,0.266,0.026,2.75,0.038,3.015v2.69H35.86V27.31l0.034-0.196c0.011-0.266,0.039-2.749,0.039-3.015C35.934,15.291,29.646,10.461,29.646,10.461z M4.37,27.114c-0.015-0.164,0.006-2.549-0.005-2.713H8.05v-1.19H4.624c0-0.014-0.259,0.002-0.259,0.002c0.145-3.085,1.32-6.163,3.539-8.59l0.093-0.1l0.166,0.144l2.452,2.454l0.77-0.772L8.78,13.746c2.358-2.156,5.35-3.393,8.542-3.535l0.185-0.001c0,0,0.077-0.003,0.072,0.046v3.634h0.981v-3.679c0.484,0.02,0.968,0.077,1.445,0.152c2.741,0.362,5.289,1.545,7.352,3.43l-2.6,2.602l0.723,0.726l2.497-2.498l0.138-0.111l0.118,0.156c2.159,2.36,3.394,5.35,3.539,8.543h-3.681v1.19l3.698-0.005c0,0,0.003,2.561-0.01,2.709L4.37,27.114z M22.8,18.528c0,0-5.844,1.792-6.963,2.909c-1.121,1.122-1.121,2.935,0.002,4.057c1.117,1.121,2.932,1.121,4.054,0C21.011,24.372,22.8,18.528,22.8,18.528z"></path>
                                <g></g>
                            </g></svg>
                            <div>Dashboard</div>
                        </a></li>
                        <li class="active"><a href="/accounts">
                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                                 xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="1000px"
                                 height="1000px" viewBox="0 0 1000 1000" enable-background="new 0 0 1000 1000"
                                 xml:space="preserve"><g>
                                <path d="M151.8,212.2h521.4c27.6,0,50-22.4,50-50v-27.6c0-27.6-22.4-50-50-50H151.8c-27.6,0-50,22.4-50,50v27.6C101.8,189.8,124.2,212.2,151.8,212.2z"></path>
                                <path d="M72,391.2h521.4c27.6,0,50-22.4,50-50v-27.6c0-27.6-22.4-50-50-50H72c-27.6,0-50,22.4-50,50v27.6C22,368.8,44.4,391.2,72,391.2z"></path>
                                <path d="M72,566.9h353c15.1-32.2,35.6-61.4,60.9-86.7c15.5-15.5,32.4-29.1,50.5-40.8H72c-27.6,0-50,22.4-50,50v27.6C22,544.5,44.4,566.9,72,566.9z"></path>
                                <path d="M151.8,615.1c-27.6,0-50,22.4-50,50v27.6c0,27.6,22.4,50,50,50h247.4c-2.2-14.9-3.3-30.1-3.3-45.4c0-28.1,3.7-55.6,11.1-82.2H151.8z"></path>
                                <path d="M72,921.7h421.4c-2.5-2.4-5.1-4.8-7.6-7.3c-28.2-28.2-50.3-61-65.8-97.6c-3.2-7.5-6-15.1-8.6-22.7H72c-27.6,0-50,22.4-50,50v27.6C22,899.3,44.4,921.7,72,921.7z"></path>
                                <polygon
                                        points="647.8,615.1 647.8,672.3 678.7,672.3 678.7,615.4 678.7,606.1 647.8,606.1 	"></polygon>
                                <rect x="728.7" y="722.3" width="28.4" height="66.2"></rect>
                                <path d="M600.5,439.9c-61,24.3-111.3,69.6-142,127.1c-8.2,15.3-14.9,31.4-20.2,48.2c-8.1,26-12.4,53.6-12.4,82.2c0,15.5,1.3,30.6,3.7,45.4c2.9,17.8,7.5,35,13.7,51.4c19.2,51.5,53.4,95.8,97.1,127.6c45.6,33.1,101.8,52.7,162.5,52.7c153,0,277-124,277-277s-124-277-277-277C666.8,420.3,632.2,427.2,600.5,439.9z M728.7,522.2v34h44.9c13.8,0,25,11.2,25,25s-11.2,25-25,25h-44.9v66.2h53.4c13.8,0,25,11.2,25,25v116.2c0,13.8-11.2,25-25,25h-53.4v34c0,13.8-11.2,25-25,25s-25-11.2-25-25v-34h-35.6h-16.7c-13.8,0-25-11.2-25-25c0-6.6,2.6-12.7,6.8-17.1c4.6-4.8,11-7.9,18.2-7.9h52.3v-46.1v-20.1h-55.9c-13.8,0-25-11.2-25-25v-82.2v-34c0-5.7,1.9-10.9,5.1-15.1c4.6-6,11.8-9.9,19.9-9.9h1.7h54.2v-34c0-13.8,11.2-25,25-25S728.7,508.4,728.7,522.2z"></path>
                            </g></svg>
                            <div>Accounts</div>
                        </a></li>
                        <li><a href="/transactions/add">
                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                                 xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="1000px"
                                 height="1000px" viewBox="0 0 1000 1000" enable-background="new 0 0 1000 1000"
                                 xml:space="preserve"><g>
                                <path d="M116.2,505.7c8.3,17.1,31.9,19.1,42.9,3.5l92-129.9c11.2-15.8,0.9-37.8-18.4-39.4l-25-2c17.7-37.2,42.6-70.8,73.5-99c44-40.1,98.6-67.4,158-79c85.3-16.6,172,0.2,244.4,47.3c60.2,39.2,104.4,95.6,127.3,161.4c8.1,23.2,32,36.9,56.1,32.2l1-0.2c29.5-5.8,47.2-36.3,37.2-64.7c-12.2-34.6-29-67.4-50.2-97.9C823.9,193.7,785,156,739,126c-46-30-96.6-50.6-150.5-61.5c-55.8-11.2-112.7-11.4-169-0.4C342,79.3,270.6,115,213,167.5C163.7,212.4,126,268,103,329.6l-31.5-2.5c-19.3-1.5-32.9,18.4-24.5,35.8L116.2,505.7z"></path>
                                <path d="M844.8,494.1l-92,129.9c-11.2,15.8-0.9,37.8,18.4,39.4l25,2c-17.7,37.2-42.6,70.8-73.5,99c-44,40.1-98.6,67.4-158,79c-85.3,16.6-172-0.2-244.4-47.3c-60.2-39.2-104.4-95.6-127.3-161.4c-8.1-23.2-32-36.9-56.1-32.2l-1,0.2c-29.5,5.8-47.2,36.3-37.2,64.7c12.2,34.6,29,67.4,50.2,97.9C180,809.7,219,847.5,265,877.4c46,30,96.6,50.6,150.5,61.5c28.2,5.7,56.7,8.5,85.2,8.5c27.9,0,55.9-2.7,83.8-8.2c77.5-15.1,149-50.9,206.6-103.3c49.3-44.9,86.9-100.5,109.9-162.1l31.5,2.5c19.3,1.5,32.9-18.4,24.5-35.8l-69.2-142.8C879.5,480.6,855.8,478.6,844.8,494.1z"></path>
                                <path d="M501,215.7c-19.3,0-35,15.7-35,35v46.1h-82.1c-19.3,0-35,15.7-35,35V500c0,19.3,15.7,35,35,35H466v98.2h-67.8c-19.3,0-35,15.7-35,35s15.7,35,35,35H466v46.1c0,19.3,15.7,35,35,35s35-15.7,35-35v-46.1h78.5c19.3,0,35-15.7,35-35V500c0-19.3-15.7-35-35-35H536v-98.2h63.8c19.3,0,35-15.7,35-35s-15.7-35-35-35H536v-46.1C536,231.4,520.4,215.7,501,215.7z M466,465h-47.1v-98.2H466V465z M579.6,535v98.2H536V535H579.6z"></path>
                            </g></svg>
                            <div>Transactions</div>
                        </a></li>
                        <li><a href="/users/${user}">
                            <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="1000px" height="1000px" viewBox="0 0 1000 1000" enable-background="new 0 0 1000 1000" xml:space="preserve"><path d="M921,219H80.1c-27.6,0-50,22.4-50,50v462c0,27.6,22.4,50,50,50H921c27.6,0,50-22.4,50-50V269C971,241.4,948.6,219,921,219zM381.5,582.7c0,15.7-8.1,29.6-20.3,37.6v-35.2c0-27.1-21.9-49-49-49h-19.5l-34.2,55l-11.9-21.1l21-33.9h-25.9h-25.9l21,33.9l-11.9,21.1l-34.2-55h-19.5c-27.1,0-49,21.9-49,49v32.2c-9.9-8.3-16.2-20.7-16.2-34.6v-249c0-24.9,20.1-45,45-45h185.4c24.9,0,45,20.1,45,45V582.7z M899,667.6c0,13.8-11.2,25-25,25H474c-13.8,0-25-11.2-25-25V665c0-13.8,11.2-25,25-25h400c13.8,0,25,11.2,25,25V667.6z M899,501.3c0,13.8-11.2,25-25,25H474c-13.8,0-25-11.2-25-25v-2.6c0-13.8,11.2-25,25-25h400c13.8,0,25,11.2,25,25V501.3z M899,335c0,13.8-11.2,25-25,25H474c-13.8,0-25-11.2-25-25v-2.6c0-13.8,11.2-25,25-25h400c13.8,0,25,11.2,25,25V335z"></path><path d="M302.6,372.7h-59.9c-38.9,0-71.8,31.8-72,70.7c-0.1,39.4,31.8,71.3,71.2,71.2c38.9-0.1,70.7-33.1,70.7-72v-59.9C312.6,377.2,308.2,372.7,302.6,372.7z"></path></svg>
                            <div>My Profile</div>
                        </a></li>
                    </c:otherwise>
                </c:choose>
            </ul>

        </div>
    </div>
</div>