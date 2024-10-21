import argparse

parser = argparse.ArgumentParser(
    prog="wq-python",
    description="WhereQ Python CLI Best Practices.",
    epilog="Example: $ python optional_args.py --verbose --format=csv",
)
parser.add_argument("--verbose", action="store_true", help="Enable verbose mode")
parser.add_argument(
    "--format", choices=["json", "csv"], default="json", help="Output format"
)

# parser.print_help()

args = parser.parse_args()

# print args iteratively
for arg in vars(args):
    print(arg, getattr(args, arg))

