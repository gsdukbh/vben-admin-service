## 准备
1. ~~在 `vue-vben-admin` 项目中，打开 `src/utils/http/axios/index.ts` 文件，并在其中找到以下代码：~~,不需要更改

```ts
const {data} = res;
if (!data) {
    // return '[HTTP] Request has no return value';
    throw new Error(t('sys.api.apiRequestFailed'));
}
//  这里 code，result，message为 后台统一的字段，需要在 types.ts内修改为项目自己的接口返回格式
const {code, result, message} = data;
```

~~并更改为：~~

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
const hasSuccess = data && Reflect.has(data, 'code') && code === ResultEnum.SUCCESS;
if (hasSuccess) {
    return data;
}
```

3. 找到`src/enums/httpEnum.ts` 文件，并在其中找到以下代码：

```ts
export enum ResultEnum {
    SUCCESS = 0,
    ERROR = 1,
    TIMEOUT = 401,
    TYPE = 'success',
}
  ```

并修改为:

```ts
export enum ResultEnum {
    SUCCESS = 200,
    ERROR = 500,
    TIMEOUT = 401,
    TYPE = 'success',
}
```