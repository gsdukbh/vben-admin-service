# vben admin service

## 关于

`vben-admin-service` 是vue 项目 ```vue-vben-admin``` 的服务端。

## 安装

```shell
git clone  https://github.com/gsdukbh/vben-admin-service.git
```

## 准备

1. 使用 idea 打开 `vben-admin-service` 项目。
2. 在 `vue-vben-admin` 项目中，打开 `src/utils/http/axios/index.ts` 文件，并在其中找到以下代码：

```ts
const {data} = res;
if (!data) {
    // return '[HTTP] Request has no return value';
    throw new Error(t('sys.api.apiRequestFailed'));
}
//  这里 code，result，message为 后台统一的字段，需要在 types.ts内修改为项目自己的接口返回格式
const {code, result, message} = data;
```

并更改为：

```ts
const resData = res.data;
if (!resData) {
    // return '[HTTP] Request has no return value';
    throw new Error(t('sys.api.apiRequestFailed'));
}
//  这里 code，result，message为 后台统一的字段，需要在 types.ts内修改为项目自己的接口返回格式
// 此项目返回的数据格式 code, data, message,timeStamp 
const {code, data, result, message} = resData;

// 这里逻辑可以根据项目进行修改
const hasSuccess = resData && Reflect.has(resData, 'code') && code === ResultEnum.SUCCESS;
if (hasSuccess) {
    return data; // 返回data 
}
```