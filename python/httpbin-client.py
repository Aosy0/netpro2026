import requests
# import main

url = 'https://httpbin.org'

def post_data():
    path = 'post'
    data = {  # リクエストボディ
        'username': 'netpro tarou',
        'password': 'netpro1234'
    }
    r = requests.post(url + '/' + path, headers=data, data="hoge")
    r.url
    print(r.status_code)  # 200
    print(type(r.json()))  # dict
    print(r.text)


# java static void main
if __name__ == '__main__':
    post_data()  # コメントを外して実行してみよう