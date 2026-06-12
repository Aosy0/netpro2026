import requests
# import main

url = 'http://localhost:8000'

def post_data():
    path = ''
    headers = {}
    response = requests.get(url + '/' + path)
    response.url
    print(response.status_code)  # 200
    print(response.text)
    # print(type(response.json()))  # dict


# java static void main
if __name__ == '__main__':
    post_data()