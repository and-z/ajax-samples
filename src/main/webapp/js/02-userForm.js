$(document).ready(function() {

    var collectFormData = function(fields){
        "use strict";

        var data = {};
        for (var i = 0; i < fields.length; i++) {
            var $item = $(fields[i]);
            data[$item.attr('name')] = $item.val();
        }
        return data;
    }

    var formSubmitHandler = function(response){
        "use strict";

        $form.find('.control-group').removeClass('error');
        $form.find('.help-inline').empty();
        $form.find('.alert').remove();

        if (response.status == 'FAIL') {
            for (var i = 0; i < response.errorMessageList.length; i++) {
                var item = response.errorMessageList[i];
                var $controlGroup = $('#' + item.fieldName + 'ControlGroup');
                $controlGroup.addClass('error');
                $controlGroup.find('.help-inline').html(item.message);
            }
        } else {
            $form.unbind('submit');
            $form.submit();
        }
    }

    var $form = $('#add-user-form');
    $form.bind('submit', function(e) {
        // Ajax validation
        var $inputs = $form.find('input');
        var data = collectFormData($inputs);

        $.post('userAjaxThyme.json',
            data,
            formSubmitHandler,
            'json'
        );

        e.preventDefault();
        return false;
    });
});