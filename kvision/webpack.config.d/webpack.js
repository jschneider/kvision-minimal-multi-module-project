// config.resolve.modules.push("../../processedResources/js/main");
config.resolve.modules.push(".");

if (config.devServer) {
    config.devServer.hot = true;
    config.devtool = 'eval-cheap-source-map';
}
