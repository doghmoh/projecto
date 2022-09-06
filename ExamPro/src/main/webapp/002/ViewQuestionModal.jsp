<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
			             	<!-- Modal -->
          <div class="modal fade" id="modelId2"  tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true" data-bs-keyboard="false" data-bs-backdrop="static">
            <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                         <h5 class="modal-title">Question Details</h5>
                         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                              <h2><x:out select="Text"/></h2>
                             <x:forEach select="Options/Option">
                             <c:set  var="test"><x:out select="IsChecked"/></c:set>
                             <c:choose>
                             <c:when test="${test == 1 }">
                             <p class="text-success"><x:out select="Text"/></p>
                             </c:when>
                             <c:otherwise>
                             <p class="text-danger"><x:out select="Text"/></p>
                             </c:otherwise>
                             </c:choose>
                            </x:forEach>
                        </div>
                    </div>
                </div>
            </div> 
</body>
</html>