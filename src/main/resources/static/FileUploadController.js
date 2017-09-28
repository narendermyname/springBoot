let myApp = angular.module('hello', ['toaster']);

let FileUploadController = function($scope, $http, toaster) {
	$scope.uploadFile = function(file) {
		console.log("uploading files...");
		var fd = new FormData();
		fd.append('file', file);
		$http.post("/upload", fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined,
				'Accept' : 'text/strings'
			}
		}).success(function(data) {
			toaster.pop('success', "success", data);
		}).error(function(error) {
			toaster.pop('error', "error", error);
		});
	};
	$http.get('/resource/').success(function(data) {
		$scope.greeting = data;
	})
}

myApp.controller('FileUploadController', [ "$scope", "$http", "toaster", FileUploadController]);

myApp.controller('FileUploadCtrl', [ '$scope', '$rootScope', 'uploadManager',
		function($scope, $rootScope, uploadManager) {
			$scope.files = [];
			$scope.percentage = 0;
			$scope.upload = function() {
				uploadManager.upload();
				$scope.files = [];
			};
			$rootScope.$on('fileAdded', function(e, call) {
				$scope.files.push(call);
				$scope.$apply();
			});
			$rootScope.$on('uploadProgress', function(e, call) {
				$scope.percentage = call;
				$scope.$apply();
			});
		} ]);
myApp.factory('uploadManager', function($rootScope) {
	var _files = [];
	return {
		add : function(file) {
			_files.push(file);
			$rootScope.$broadcast('fileAdded', file.files[0].name);
		},
		clear : function() {
			_files = [];
		},
		files : function() {
			var fileNames = [];
			$.each(_files, function(index, file) {
				fileNames.push(file.files[0].name);
			});
			return fileNames;
		},
		upload : function() {
			$.each(_files, function(index, file) {
				file.submit();
			});
			this.clear();
		},
		setProgress : function(percentage) {
			$rootScope.$broadcast('uploadProgress', percentage);
		}
	};
});

myApp.directive('upload', [
		'uploadManager',
		function factory(uploadManager) {
			return {
				restrict : 'A',
				link : function(scope, element, attrs) {
					$(element).fileupload(
							{
								dataType : 'text',
								add : function(e, data) {
									uploadManager.add(data);
								},
								progressall : function(e, data) {
									var progress = parseInt(data.loaded
											/ data.total * 100, 10);
									uploadManager.setProgress(progress);
								},
								done : function(e, data) {
									uploadManager.setProgress(0);
								}
							});
				}
			};
		} ]);

myApp.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);
