import argparse

parser = argparse.ArgumentParser(
    prog="wq-python", description="WhereQ Python CLI Best Practices"
)

parser.add_argument("first_arg", help="The first arg")
parser.add_argument("second_arg", help="The second arg")
args = parser.parse_args()
print("first_arg: ", args.first_arg)
print("second_arg:", args.second_arg)

# Test
# args = parser.parse_args(["arg_1", "arg_2"])
# print("$ python postional_args.py arg_1 arg_2\n")

# Run
# python positional_args.py agr_1 arg_2
# Output
# first_arg:  arg_1
# second_arg: arg_2

# Run without args
# python positional_args.py
# Output
# usage: wq-python [-h] first_arg second_arg
