import json
import random
import string
import re
import requests
import names
from lxml import etree
from bs4 import BeautifulSoup

"""
Task 1
The following section is mainly targeted to randomly generated a requested dictionary
"""


def random_char(length):
	return ''.join(random.choice(string.ascii_lowercase) for _ in range(length))


def q1_function_generator():
	_genders = ['M', 'F']
	_special_month = 2
	_31_days_month = [1, 3, 5, 7, 8, 10, 12]
	gender_index = random.randint(1, 3)
	random_name = names.get_full_name(gender='female' if gender_index % 2 == 1 else 'male')
	birth_year = random.randint(1920, 2021)
	birth_month = random.randint(1, 13)
	birth_day = random.randint(1, (
		31 if birth_month in _31_days_month
		else 30 if birth_month != _special_month
		else 28 if birth_year % 4 == 0
		else 29) + 1)

	return {
		'name': random_name,
		'gender': _genders[gender_index % 2],
		'dateOfBirth': '{0:02d}/{1:02d}/{2:04d}'.format(birth_day, birth_month, birth_year),
		'phoneNumber': '{0:08d}'.format(random.randint(0, 100000000)),
		'email': random_char(8) + "@gmail.com",
		'address': random_char(12) + '\n' + random_char(12) + ', ' + random_char(8)
	}


"""
Task 2
The following section is mainly targeted to certify the validaity of a credit card number
"""


def q2_check_credit_card_number(card_number):
	remove_hyphen = card_number.replace("-", "")
	return re.search(r"^[4-6][0-9]{3}-[0-9]{4}-[0-9]{4}-[0-9]{4}$", card_number) is not None and len(remove_hyphen) == 16 and re.search(r"(\d)\1{3,}", remove_hyphen) is None


"""
Task 3
The following section is mainly targeted to parse all headlines of news
"""


def q3_get_nyt_titles():
	result = []
	soup = BeautifulSoup(requests.get('https://www.nytimes.com/').content, 'html.parser')
	for elm in soup.find_all('h3'):
		result.append(elm.text)
	return result


if __name__ == '__main__':
	print('Task 1 Result: {}'.format(json.dumps(q1_function_generator(), indent=4)))
	print('Task 2 Result 1 (1234-5678-9012-3456): {}'.format(q2_check_credit_card_number('1234-5678-9012-3456')))
	print('Task 2 Result 2 (4234-5678-9012-345): {}'.format(q2_check_credit_card_number('4234-5678-9012-345')))
	print('Task 2 Result 3 (4234-A678-9012-3456): {}'.format(q2_check_credit_card_number('4234-A678-9012-3456')))
	print('Task 2 Result 4 (42345678-9012-3456): {}'.format(q2_check_credit_card_number('42345678-9012-3456')))
	print('Task 2 Result 5 (4234_5678 9012_3456): {}'.format(q2_check_credit_card_number('4234_5678 9012_3456')))
	print('Task 2 Result 6 (4444-5678-9012-3456): {}'.format(q2_check_credit_card_number('4444-5678-9012-3456')))
	print('Task 2 Result 7 (5553-5678-9012-3456): {}'.format(q2_check_credit_card_number('5553-5678-9012-3456')))
	print('Task 3 Result: {}'.format(json.dumps(q3_get_nyt_titles(), indent=4)))
