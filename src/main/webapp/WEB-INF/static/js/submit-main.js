$(function () {
    "use strict";
    var $upload;
    var uploads = [];
    $upload = $(".upload");
    $upload.each(function (key,node) {
        uploads.push(new Choose_upload(node));
    });
});