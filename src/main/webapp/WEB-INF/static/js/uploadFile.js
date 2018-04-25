$(function () {
    'use strict';
    let typeId = 1;
    const choose = new Choose_upload($(".post-type"));
    choose.changeColorandType();


    $(".post-type").each(function () {
        $(this).click(function () {
            console.log($(this));
            typeId = $(this).attr('data-flag');
            console.log(typeId);
        })
    });




    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        var demoListView = $('#demoList')
            , uploadListIns = upload.render({
            elem: '#upload_main'
            , url: '/ajax/upload/'
            , accept: 'file'
            , multiple: true
            , before: function (obj) {
                this.data.params = typeId;
                console.log(this.data.params);
            }
            , drag: true
            , auto: false
            , method: "POST"
            , bindAction: '#testListAction'
            , choose: function (obj) {
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                        , '<td>等待上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
                        , '<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function () {
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            , done: function (res, index, upload) {
                if (res.code == 1) { //上传成功
                    var tr = demoListView.find('tr#upload-' + index)
                        , tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                } else {
                    alert("上传失败")
                }
            }
            , error: function (index, upload) {
                var tr = demoListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">服务器忙，请刷新</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    })
})