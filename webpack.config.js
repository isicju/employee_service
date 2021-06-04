var HtmlWebpackPlugin = require('html-webpack-plugin');
var path = require('path');

module.exports = {
    entry: './index.js',
    devServer: {
        port: 9000
    },
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle1.js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            }
        ]
    },
    plugins: [new HtmlWebpackPlugin({
        template: './index.html'
    })]
};
